import java.util.LinkedList;
import java.util.Queue;

public class kakao_blind_2020_Block_Movement {
	static int N;
	static class Robot{
		Point a;
		Point b;
		int status; // 상태 가로  0  세로 1
		public Robot(Point a, Point b, int status) {
			this.a = a;
			this.b = b;
			this.status = status;
		}
	}
	static class Point{
		int row,col;
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	static boolean[][] check;
	static int[][] time;
	static int dr[] = {0,0,-1,1}; // 0 1 2 3
	static int dc[] = {1,-1,0,0}; // 오 왼 상 하
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
		N = board.length;
		check = new boolean[N][N]; // 방문한적있는지 확인  // 움직이는 쪽 기준으로 방문체크해야함 한칸씩 체크
		time = new int[N][N];
		// 그 움직이는 한칸이 N-1 N-1에 도달할때 
		// 로봇 크기는 2X1
		// NX N 지도 
		// 0은 빈칸 1은 벽 
		// 0 0 기준으로 N-1 N-1이 도착지점  //가중치 1 최소시간 BFS
		bfs(new Robot(new Point(0,0),new Point(0,1),0),board); // 00 01 가로상태로 bfs 시작
		int answer = time[N-1][N-1];
		
	}
	private static void bfs(Robot robot, int[][] board) {
		// 초기설정
		Queue<Robot> r = new LinkedList<>();
		r.add(robot);
		time[robot.a.row][robot.a.col] = 0;
		time[robot.b.row][robot.b.col] = 0;
		//check[robot.a.row][robot.a.col] = true;
		//check[robot.b.row][robot.b.col] = true;
		
		while(!r.isEmpty()) {
			Robot t = r.poll();
			// 상하좌우이동체크먼저
			for(int k = 0; k < 4; k++) {
				int mar = t.a.row + dr[k];
				int mac = t.a.col + dc[k];
				int mbr = t.b.row + dr[k];
				int mbc = t.b.col + dc[k];
				int rs = t.status;
				//가로 일때 좌우이동은 한칸이 겹쳐서 이동 
				//세로 일땐 상하이동은 한칸이 겹쳐서 이동 
				if(isIn(t.a,t.b) && isWall(t.a,t.b,board)) { // 이동할 위치가 경계안이고 벽이아니면 
					// 방문한적있는지 확인해야함
					//1. 가로일경우 좌우 이동이면 방향별로 한칸만 방문확인 // 0 : 오  1 : 왼
					if(rs == 0 && k == 0) { //가로고 오른쪽으로 이동하면 
						if(time[mbr][mbc] == 0 || time[t.b.row][t.b.col]+1 <= time[mbr][mbc]) {
							time[mbr][mbc] = time[t.b.row][t.b.col] + 1;
							r.add(new Robot(new Point(mar,mac),new Point(mbr,mbc),rs));
						}
					}else if(rs == 0 && k == 1) { // 가로고 왼쪽으로 이동하면
						if(isNotStart())
					}
				}
			}
		}
		
	}
	private static boolean isWall(Point a, Point b, int[][] board) {
		return board[a.row][a.col] == 0 && board[b.row][b.col] == 0; 
	}
	private static boolean isIn(Point a, Point b) {
		// TODO Auto-generated method stub
		boolean border = (a.row >= 0 && a.row < N && a.col >=0 && a.col < N && b.row >=0 && b.row < N && b.col >=0 && b.col < N ) ? true : false;
		return border;
	}

}