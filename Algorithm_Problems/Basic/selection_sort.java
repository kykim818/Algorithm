import java.util.Arrays;

/**
 * @author kykim818@naver.com
 * 선택정렬 
 * 시간복잡도 n * n 
 * 선택 정렬의 장점
    - 데이터의 양이 적을 때 좋은 성능을 나타냄.
    - 작은 값을 선택하기 위해서 비교는 여러번 수행되지만 교환횟수가 적다.
 * 선택 정렬의 단점
    - 100개 이상의 자료에 대해서는 속도가 급격히 떨어져 적절히 사용되기 힘들다.
 */

public class selection_sort {
	
	public static void main(String[] args) {
		int[] arr = {5,2,4,7,8,1,3};
		int[] res = new int[arr.length];
		res = sort(arr);
		System.out.println(Arrays.toString(res));
	}

	private static int[] sort(int[] arr) {
		// 맨 앞부터 맨 뒤까지 제일 작은 값을 찾고 순서대로 교환해준다.
		for(int i = 0; i < arr.length-1; i++) {
			int val = arr[i]; // 비교값 기준
			int idx = i; // 교환할 idx 저장 .처음에는 자기자신 
			for(int j = i+1; j < arr.length; j++) { // 뽑은애 이후로 전부 비교해준다.
				if(val > arr[j]) {
					val = arr[j];
					idx = j;
				}
			}
			// 그다음 두자리를 바꿔준다.
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		return arr;
	}

}
