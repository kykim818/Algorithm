import java.util.HashSet;
import java.util.Scanner;

public class sw7699_suzy_travel {
    static int R;  // row
	static int C;  // col
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static char[][] map;
	//static boolean[][] check;
	static HashSet<Character> set;
	static int answer;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	
		set = new HashSet<>();
		for(int tc = 1; tc <= T; tc++) {
			R = sc.nextInt(); // 1 <= R <= 20
			C = sc.nextInt(); // 1 <= C <= 20
			map = new char[R][C];
			//check = new boolean[R][C];
			set.clear();
			for(int i = 0; i < R; i++ ) {
				String input = sc.next();
				for(int j = 0; j < C; j++) {
					map[i][j] = input.charAt(j);
					//input.readLine().toCharArray();
				}
			}
			answer = 0; //
			cnt = 0; 
			//최단거리를 물어보지 않앙기때문에 BFS가 아닌 DFS를 사용한다.
			//최적화 -- 알파벳이기때문에 방문최대길이는 26이다.
			//check= new boolean['Z'+1];
			//check[map[0][0]] = true;
			dfs(0,0);
			
			System.out.println("#"+ tc + " "+ answer);
		}// end of test case
	}
	private static void dfs(int row, int col) {
		//check[row][col] = true;
		
		set.add(map[row][col]);
		cnt++;
		if(cnt >= answer)
			answer = cnt;
		//
		if(answer == 26)
			return;
		
		for(int k = 0; k < 4; k++) {
			int mov_row = row + dr[k];
			int mov_col = col + dc[k];
			// 범위
			if(mov_row >= 0 && mov_row < R && mov_col >= 0 && mov_col < C) {
				if(set.contains(map[mov_row][mov_col]) == false) {
					dfs(mov_row,mov_col);
					cnt--;
					set.remove(map[mov_row][mov_col]);
					//check[mov_row][mov_col] = false;
				}
			}
		}
	}
}