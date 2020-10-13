import java.util.Arrays;

public class Monthly_challenge_quad_compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] arr = { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };
		int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
//		int[][] arr = {{0,0},{0,0}};
		int[] answer = { 0, 0 };

		int n = arr.length;
		boolean[][] check = new boolean[n][n];
		for (boolean[] row : check) {
			Arrays.fill(row, false);
		}
		int a = arr[0][0];
		boolean c1 = false;
		L: for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a != arr[i][j]) {
					c1 = true;
					break L;
				}
			}
		}
		if (c1) {
			compression(arr, n, check, 0, 0,answer);
		} else {
			if (a == 0) {
				answer[0] = 1;
			} else {
				answer[1] = 1;
			}
		}
		System.out.println(Arrays.toString(answer));
		for(int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(check[i]));
		}
		
	}

//0 1 2 3 4 5 6 7
	private static void compression(int[][] arr, int n, boolean[][] check, int start_row, int start_col, int[] answer) {
		
		if(n == 2) {
			for(int i = start_row; i <start_row+n; i++) {
				for(int j = start_col; j<start_col+n; j++) {
					answer[arr[i][j]]++;
				}
			}
			return;
		}
		
		boolean check2 = true;
		int tmp = arr[start_row][start_col];
		// TODO Auto-generated method stub
		L: for (int i = start_row; i < start_row + n / 2; i++) {
			for (int j = start_col; j <start_col + n / 2; j++) {
				if (tmp != arr[i][j]) {
					check2 = false;
					break L;
				}
			}
		}
		if (check2) {
			for (int i = start_row; i <start_row+ n / 2; i++) {
				for (int j = start_col; j <start_col+ n / 2; j++) {
					check[i][j] = true;
				}
			}
			answer[tmp]++;
		} else {
			compression(arr, n / 2, check, start_row, start_col,answer);
		}

		tmp = arr[start_row][start_col + n / 2];
		check2 = true;
		L1: for (int i = start_row; i <start_row + n / 2; i++) {
			for (int j =start_col + n / 2; j < start_col + n; j++) {
				if (tmp != arr[i][j]) {
					check2 = false;
					break L1;
				}
			}
		}
		if (check2) {
			for (int i = start_row; i < start_row +n / 2; i++) {
				for (int j =start_col + n / 2; j <start_col + n; j++) {
					check[i][j] = true;
				}
			}
			answer[tmp]++;
		} else {
			compression(arr, n / 2, check, start_row,start_col + n / 2,answer);
		}

		tmp = arr[start_row + n / 2][start_col];
		check2 = true;
		L2: for (int i = start_row + n / 2; i < start_row + n; i++) {
			for (int j = start_col; j < start_col + n/2; j++) {
				if (tmp != arr[i][j]) {
					check2 = false;
					break L2;
				}
			}
		}
		if (check2) {
			for (int i = start_row + n/2; i <start_row + n; i++) {
				for (int j = start_col; j <start_col + n/2; j++) {
					check[i][j] = true;
				}
			}
			answer[tmp]++;
		} else {
			compression(arr, n / 2, check, start_row + n / 2, start_col,answer);
		}
		
		tmp = arr[start_row + n / 2][start_col + n / 2];
		check2 = true;
		L3: for (int i = start_row + n / 2; i <start_row + n; i++) {
			for (int j = start_col + n / 2; j <start_col + n; j++) {
				if (tmp != arr[i][j]) {
					check2 = false;
					break L3;
				}
			}
		}
		if (check2) {
			for (int i =start_row + n / 2; i <start_row + n; i++) {
				for (int j = start_col + n / 2; j <start_col + n; j++) {
					check[i][j] = true;
				}
			}
			answer[tmp]++;
		} else {
			compression(arr, n / 2, check,start_row + n / 2,start_col + n / 2,answer);
		}
	}
}
