import java.util.*;

public class baekjoon_17142_laboratory3 {
	static int N,M; // N크기 M은 활성화시킬바이러스 개수
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static int[][] map; // 0은 빈칸 1은 벽 2는 바이러스가 있는곳
	static class Point{
		int row,col;
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	static int answer;
	static int hole; 
	static ArrayList<Point> list = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map= new int[N][N];
		
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < N; j++) {
				int input = sc.nextInt();
				map[i][j] = input;
				if(input == 2) {
					list.add(new Point(i,j));
				}
				if(input == 0) {
					hole++;
				}
			}
		}
		if(hole == 0) {
			answer = 0;
		}
		else {
			int[] arr = new int[list.size()];
			for(int i = 0; i<list.size(); i++) {
				arr[i] = i;
			}
			int[] res = new int[M];
			//순서상관없고 중복 안됨 조합
			answer = Integer.MAX_VALUE;
			combination(0,0,res,arr);
			if(answer == Integer.MAX_VALUE)
				answer = -1;
		}
		System.out.println(answer);
	}
	private static void combination(int cnt, int idx, int[] res, int[] arr) {
		if(cnt == M) {
			int tmp_hole = hole;
			// 봅은수만큼 바이러스활성화
			Queue<Point> q= new LinkedList<Point>();
			int[][] copy = new int[N][N];
			boolean[][] check = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					copy[i][j] = map[i][j];
					check[i][j] = false;
				}
			}
			for(int i = 0; i < M; i++) {
				Point tmp = list.get(res[i]);
				copy[tmp.row][tmp.col] = 3; //활성화시킨놈을 -1
				check[tmp.row][tmp.col] = true;
				q.add(new Point(tmp.row,tmp.col));
			}
			int time = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				for(int j = 0; j < size; j++) {
					Point tmp = q.poll();
					for(int k =0; k<4; k++) {
						int mov_r = tmp.row + dr[k];
						int mov_c = tmp.col + dc[k];
						if(isIn(mov_r,mov_c)) {
							if(copy[mov_r][mov_c] == 1 || check[mov_r][mov_c] == true)
								continue;
							if(copy[mov_r][mov_c] == 0)
								tmp_hole--;
							copy[mov_r][mov_c] = 3;
							check[mov_r][mov_c] = true;
							q.add(new Point(mov_r,mov_c));
						}
					}
				}
				time++;
////				for(int i = 0; i < N; i++) {
////					System.out.println(Arrays.toString(copy[i]));
////				}
//				System.out.println();
//				boolean finish = true;
//				for(int i = 0; i < N; i++) {
//					for(int j = 0; j < N; j++) {
//						if(copy[i][j] == 0)
//							finish = false;
//					}
//				}
				if(tmp_hole == 0) {
					answer = Math.min(answer, time);
				}
			}
			return;
		}
		if(idx == arr.length) return;
		res[cnt] = arr[idx];
		combination(cnt+1, idx+1, res, arr);
		combination(cnt,idx+1,res,arr);
	}
	private static boolean isIn(int r, int c) {
		// TODO Auto-generated method stub
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
