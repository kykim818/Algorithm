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
			// 개수를 전부 뽑으면 출력 0 1 2이므로 3일때가 다뽑은것 
			System.out.println(Arrays.toString(res));
			cnt++;
			return;
		}
		for(int i = 0; i< arr.length; i++) {
			//중복이가능하므로 따로 썻는지 않썻는지를 체크할 필요가 없음
			res[res_idx] = arr[i];
			permutation_overlap(arr, res, res_idx+1, length);
		}
	}

}
