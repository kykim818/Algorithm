import java.util.Arrays;

public class quick_sort {
	//같은수 들으가면 무한 루프 .. 수정해야함
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,4,5,2,6,1,3,8};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if(low >= high) return;
		
		int mid = partition(arr,low,high);
		quickSort(arr, low, mid-1);
		quickSort(arr, mid+1, high);
		
	}

	private static int partition(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int pivot = arr[(low+high)/2];
		while(low < high) {
			while(arr[low] < pivot) low++;
			while(arr[high] > pivot) high--;
			
			if(low < high) {
				int tmp = arr[low];
				arr[low] = arr[high];
				arr[high] = tmp;
			}
		}
		return high;
	}

}
