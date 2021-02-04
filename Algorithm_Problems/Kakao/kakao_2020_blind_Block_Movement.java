import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class kakao_2020_blind_Block_Movement {
	static int N;
	static class Robot{
		int row,col; // 기준점 
		int s; // 상태 가로  0  세로 1
		public Robot(int row, int col, int status) {
			this.row = row;
			this.col = col;
			this.s = status;  // 0 이 가로 // 세로 
		}
	}
	static int[][][] time; // 방문과 시간을 다익스트라로 체크한다. 
	static int dr[] = {0,0,-1,1}; // 0 1 2 3
	static int dc[] = {1,-1,0,0}; // 오 왼 상 하
	static int drr[] = {0,0,-1,-1}; // 가로일때 01이 아래로 23이 위로회전
	static int drc[] = {0,1,0,1};
	static int dcr[] = {0,1,0,1}; //세로일대 01이 왼쪽 23이 오른쪽
	static int dcc[] = {-1,-1,0,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
		N = board.length;
		time = new int[N][N][2]; // 방문한적있는지 확인  // 움직이는 쪽 기준으로 방문체크해야함 한칸씩 체크
		// 최소 시간을 구해야하므로 큰수로 채워놓는다.
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				Arrays.fill(time[i][j], Integer.MAX_VALUE);
			}
		}
		bfs(0,0,0,board); // 0,0을기준점으로 가로상태로 출발한다.
		int answer = Math.min(time[N-1][N-2][0], time[N-2][N-1][1]);
		System.out.println(answer);
	}
	private static void bfs(int row, int col, int s, int[][] board) {
		Queue<Robot> q = new LinkedList<>();
		q.add(new Robot(row,col,s));
		time[row][col][0] = 0; 
		while(!q.isEmpty()) {
			Robot tmp = q.poll();
			int nr = tmp.row;
			int nc = tmp.col;
			int ns = tmp.s; 
			// 상하좌우이동먼저 처리 0 1 2 3 오 왼 상 하
			for(int k = 0; k < 4; k++) {
				if(isCanGo(nr,nc,ns,k,board)) {
					int mr = nr + dr[k];
					int mc = nc + dc[k];
					if(time[mr][mc][ns] > time[nr][nc][ns] + 1) {
						time[mr][mc][ns] = time[nr][nc][ns] + 1;
						q.add(new Robot(mr,mc,ns));
					}
				}
			}
			for(int k = 0 ; k< 4; k++) {
				if(isCanRoate(nr,nc,ns,k,board)) {
					if(ns == 0) { //현재 상태가 가로였다면 
						int mr = nr + drr[k];
						int mc = nc + drc[k];
						if(time[mr][mc][(1-ns)] > time[nr][nc][ns] + 1) {
							time[mr][mc][(1-ns)] = time[nr][nc][ns] + 1;
							q.add(new Robot(mr,mc,1-ns));
						}
					}else { // 현재 상태가 세로였다면
						int mr = nr + dcr[k];
						int mc = nc + dcc[k];
						if(time[mr][mc][(1-ns)] > time[nr][nc][ns] + 1) {
							time[mr][mc][(1-ns)] = time[nr][nc][ns] + 1;
							q.add(new Robot(mr,mc,1-ns));
						}
					}
				}
			}
		}
	}
	private static boolean isCanRoate(int r, int c, int s, int k, int[][] board) {
		if(s == 0) { // 현재가로 
			if(k < 2) { //아래로 회전
				return r+1 < N && c+1 < N && board[r+1][c] != 1 && board[r+1][c+1] != 1;
			}else { // 위로회전 r-1 c r-1 c+1
				return r-1 >= 0 && c+1 < N && board[r-1][c] != 1 && board[r-1][c+1] != 1;
			}
		}else { // 현재세로
			if(k < 2) { //왼쪽으로 회전 r c-1 r+1 c-1
				return c-1 >= 0 && r+1 < N && board[r][c-1] != 1 && board[r+1][c-1] != 1;
			}else { // 오른쪽으로 회전 r c+1 r-1 c+1
				return r-1 >= 0 && c+1 < N && board[r][c+1] != 1 && board[r+1][c+1] != 1;
			}
		}
	}
	private static boolean isCanGo(int r, int c, int s, int k, int[][] board) {
//		0 1 2 3 오 왼 상 하
		if(k == 0) {
			if(s == 0) { // 가로일때 오른쪽으로 갈수 있는지확인
				return c+2 < N && board[r][c+2] != 1;
			}else { // 세로일때 오른쪽으로 갈수 있는지 확인
				return c+1 < N && r+1 < N && board[r][c+1] != 1 && board[r+1][c+1] != 1;
			}
		}else if(k == 1) {
			if(s == 0) { // 가로일때 왼쪽으로 갈수 있는지확인
				return c-1 >=0 && board[r][c-1] != 1;
			}else { // 세로일때 왼쪽으로 갈수 있는지 확인
				return r+1 < N && c-1 >= 0 && board[r][c-1] != 1 && board[r+1][c-1] != 1;
			}
		}else if(k == 2) {
			if(s == 0) { // 가로일때 위쪽으로 갈수 있는지확인
				return r-1 >= 0 && c+1 < N && board[r-1][c] != 1 && board[r-1][c+1] != 1;
			}else { // 세로일때 위쪽으로 갈수 있는지 확인
				return r-1 >= 0 && board[r-1][c] != 1;
			}
		}else {
			if(s == 0) { // 가로일때 아래쪽으로 갈수 있는지확인
				return r+1 < N && c+1 < N && board[r+1][c] != 1 && board[r+1][c+1] != 1;
			}else { // 세로일때 아래쪽으로 갈수 있는지 확인
				return r+2 < N && board[r+2][c] != 1;
			}
		}
	}
	

}