import java.util.Arrays;

public class permutation {
	static int cnt;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		int[] res = new int[3];
		boolean[] visited = new boolean[5];
		// 5개중 3개 선택하기 순서상관있음
		// 중복안됨 
		// 123 213
		permutation(arr,res,visited,0);
		System.out.println(cnt);
	}

	private static void permutation(int[] arr, int[] res, boolean[] visited, int res_idx) {
		if(res_idx == 3) {
			cnt++;
			System.out.println(Arrays.toString(res));
			return;
		}
		for(int i = 0; i< arr.length; i++) {
			if(!visited[i]) {
				res[res_idx] = arr[i];
				visited[i] = true;
				permutation(arr, res, visited, res_idx+1);
				visited[i] = false;
			}
		}
	}

}
