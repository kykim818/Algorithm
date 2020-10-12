import java.util.Arrays;

public class Monthly_challenge_quad_compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1} ,{1,1,1,1}};
		int[] answer = {0,0};
		
		int n = arr.length;
		boolean[][] check = new boolean[n][n];
		for(boolean[] row : check) {
			Arrays.fill(row, false);
		}
		int a = arr[0][0];
		boolean c1 = false;
		L:for(int i = 0; i< n; i++) {
			for(int j = 0; j<n; j++) {
				if(a != arr[i][j]) {
					c1 = true;
					break L;
				}
			}
		}
		if(c1) {
			compression(arr,n);
			for(int i =0; i< n; i++) {
				for(int j =0; j<n; j++) {
					if(arr[i][j] == 0) answer[0]++;
					else answer[1]++;
				}
			}
			
			
		}
		else {
			if(a == 0) {
				answer[0] = n*n;
			}else {
				answer[1] = n*n;
			}
		}
		
		
		
	}
//0 1 2 3
	private static void compression(int[][] arr, int n) {
		// TODO Auto-generated method stub
		boolean check2 = false;
		int tmp = arr[0][0];
		for(int i = 0; i< n/2; i++ ) {
			for(int j = 0; j < n/2; j++) {
				
			}
		}
	}
}
