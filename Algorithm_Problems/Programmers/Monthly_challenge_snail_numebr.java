import java.util.Arrays;

public class programmers_02_snail_number {
	static int dr[] = {1,0,-1}; // 하 우 좌상 
	static int dc[] = {0,1,-1};
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int cnt = sum(n);
		int [] answer =new int[cnt];
		map = new int[n][n];
		int sr = 0;
		int sc = 0;
		int start = 1;
		int dir = 0;
		for(int i = n; i > 0 ; i--) { // 4 3 2 1
			int tmp = i;
			while(tmp != 0) {
				if(map[sr][sc] == 0) {
					map[sr][sc] = start++;
				}
				if(tmp == 1)
					dir = (dir + 1) % 3; 
				sr += dr[dir];
				sc += dc[dir];
				tmp--;
			}
		}
		int idx = 0;
		for(int i = 0; i< n; i++) {
			for(int j= 0; j<n;j++) {
				if(map[i][j] == 0)
					break;
				answer[idx++] = map[i][j];
			}
		}
		System.out.println(Arrays.toString(answer));
		
	}
	static int sum(int n) {
		int ret = 0;
		for(int i = 1; i<= n; i++) {
			ret += i;
		}
		return ret;
	}
}
