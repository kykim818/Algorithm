import java.util.Arrays;

public class combination_overlap {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1,2,3,4,5};
		int[] res = new int[3];
		// n H r = n+r-1 C r 
		// 5 H 3 = 7 C 3  = 35가 나와야한다.
		combination_overlap(arr,res,0,0,3);
		System.out.println(N);
	}

	private static void combination_overlap(int[] arr, int[] res, int arr_idx, int res_idx, int cnt) {
		//재귀
		if(cnt == 0) {
			N++;
			System.out.println(Arrays.toString(res));
			return;
		}
		if(arr_idx == arr.length) return;
		
		res[res_idx] = arr[arr_idx];
		//뽑을떄
		combination_overlap(arr, res, arr_idx, res_idx+1, cnt-1);
		//안뽑을떄
		combination_overlap(arr, res, arr_idx+1, res_idx, cnt);
	}

}
