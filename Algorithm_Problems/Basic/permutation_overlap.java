import java.util.Arrays;

public class permutation_overlap {
	static int cnt;
	public static void main(String[] args) {
		//
		int[] arr = {1,2,3,4,5};
		int[] res = new int[3];
		// 중복 순열 
		//5개중에 3개뽑기 5 5 5 125개나와야함 
		permutation_overlap(arr,res,0,arr.length);
		System.out.println(cnt);
		
	}
	private static void permutation_overlap(int[] arr, int[] res, int res_idx, int length) {
		// TODO Auto-generated method stub
		if(res_idx == 3) {
			System.out.println(Arrays.toString(res));
			cnt++;
		}
		for(int i = 0; i< arr.length; i++) {
			permutation_overlap(arr, res, res_idx, length);
		}
	}

}
