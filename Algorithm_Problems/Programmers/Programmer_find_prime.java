import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_find_prime {
	static int cnt;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numbers ="011";
		int len = numbers.length();
		int[] arr = new int[len];
		for(int i = 0; i < len; i++) {
			arr[i] = numbers.charAt(i)-'0';
		}
		System.out.println(Arrays.toString(arr));
		boolean[] check = new boolean[len];
		for(int i = 1; i <= len; i++) {
			int[] res = new int[i];
			permutation(0,check,arr,res);
		}
	}

	private static void permutation(int res_idx, boolean[] check, int[] arr, int[] res) {
		// TODO Auto-generated method stub
		if(res_idx == res.length) {
			if(res[0] == 0) return;
			
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(!check[i]) {
				res[res_idx] = arr[i];
				check[i] = true;
				permutation(res_idx+1, check, arr, res);
				check[i] = false;
			}
		}
	}

}
