// 중복을 허용하지 않는 조합 
import java.util.Arrays;

public class combination {

	public static void main(String[] args) {
		// 중복X 조합 구현해보기
		int[] arr = {1,2,3,4,5};
		int[] res = new int[2];
		combination(arr,res,0,0,res.length);
		
	}

	private static void combination(int[] arr, int[] res, int res_idx, int arr_idx, int cnt) {
		// arr은 선택할 배열 res는 결과 배열 결정해야할 res 배열의 idx , cnt는 뽑아야하는 개수
		// recursion방식 - 
		if(cnt == 0) {
			System.out.println(Arrays.toString(res));
			return;
		}
		if(arr_idx == arr.length) return;
		// 뽑아서넣고 
		res[res_idx] = arr[arr_idx];
		//선택한경우
		combination(arr, res, res_idx+1,arr_idx+1,cnt-1);
		//선택하지 않은경우
		combination(arr, res, res_idx, arr_idx+1, cnt);
		
		
	}

}
