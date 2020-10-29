import java.util.Arrays;
/**
 * 
 * @author kykim818@naver.com
 *	삽입정렬 
 *	구현이 간단한 정렬중하나 
 *	요점은 Key를 배열의 2번째값으로 주고, 
 *  키 기준으로 앞부분과 비교하면서 키보다 크면 뒤로보내고 작으면 그 뒤쪽에 값을 넣는것 
 *  정렬이 되어있으면 o(n) 
 *  역순정렬이면 O(n^2) 
 */
public class insertion_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {8,5,2,4,3};
		
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void insertionSort(int[] arr) {
		// TODO Auto-generated method stub
		if(arr.length <= 1) return;
		int key = 0; // 두번째를 키로 시작
		int idx = 0;
		for(int i = 1; i < arr.length; i++) {
			key = arr[i];
			idx = i-1;
			
			while(idx >= 0 && key < arr[idx]) {
				arr[idx+1] = arr[idx];
				idx--;
			}
			arr[idx+1] = key;
			// 처음에 짯던 코드인데
			// 분기문덕에 좀 복잡해보여서 위로 수정
//			for(int j = i-1; j >= 0; j--) {
//				if(key < arr[j]) { // 키가 비교한거보다 작다.
//					arr[j+1] = arr[j]; // 비교한애를 뒤로한칸보냄
//				}else { // 키보다 작다 -> 그러면 작은애 뒤로 키가 들어가면 된다.
//					arr[j+1] = key;
//					break;
//				}
//				// 다돌았는데 작은애가없으면 내가 첫번째다 !
//				if(j == 0) arr[j] = key;
//			}
			
			}
	}

}
