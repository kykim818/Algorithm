import java.util.*;

public class baekjoon_19237_adult_shark {
	static int[][][] map; // 3차원 냄새 기록
	static int[][][] ds; // 상어별 번호 별 현재 방향별 방향 우선순위
	static int N,M,K;
	static int[] dr= {0,-1,1,0,0};
	static int[] dc= {0,0,0,-1,1};
	static class Shark{
		int row,col,num;
		public Shark(int num,int row, int col) {
			this.num = num;
			this.row = row;
			this.col = col;
		}
	}
	static List<Shark> pos = new LinkedList<>();
	static Queue<Shark> q = new LinkedList<>();
	public static void main(String[] args) {
		// 1<= 번호 <= M
		// 1번은 다 이김
		// NXN M마리
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//맵 크기
		M = sc.nextInt();//상어 수
		ds = new int[M+1][5][5]; //행이 상어번호 뒤가 우선순휘 0~3까지
		K = sc.nextInt();//냄새가 사라지는 시간
		map = new int[N][N][4]; // 0은 상어들 1은 현재 방향 2 냄새정보 3 남은시간
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int a = sc.nextInt();
				if(a != 0) {
					map[i][j][0] = a;
					map[i][j][2] = a; // 들어올때 냄새도 같이 기록
					map[i][j][3] = K;
					pos.add(new Shark(a,i,j));
					q.add(new Shark(a,i,j));
				}
			}
		}
		int[] csd = new int[M+1];
		for(int i = 1; i<=M; i++) {
			csd[i] = sc.nextInt();
		}
		for(int i = 1; i<= M ; i++) {
			Shark tmp = pos.get(i-1);
			map[tmp.row][tmp.col][1] = csd[tmp.num];
		}
		
		for(int p = 1; p <= M; p++) {
			for(int q = 1; q<=4; q++) { // 현재 방향
				for(int r = 1; r<=4; r++) {
					ds[p][q][r] = sc.nextInt();
				}
			}
		}
		// 현재 큐에 상어 번호 상관없이 // 번호 행 열 // 순서로 들어가있음.	
		int answer = simulate();
		
		
		System.out.println(answer);
		
//		System.out.println("---------------------------출력부---------------------------");
//		// 맵출력 // 상어
//		System.out.println("상어");
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N;j ++) {
//				System.out.print(map[i][j][0]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("방향");
//		// 맵출력 // 냄새
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N;j ++) {
//				System.out.print(map[i][j][1]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("냄새");
//		// 맵출력 // 냄새
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N;j ++) {
//				System.out.print(map[i][j][1]+" ");
//			}
//			System.out.println();
//		}
//		
//		for(int i = 1; i <= M; i++) {
//			for(int j = 1; j<= 4; j++) {
//				for(int p =1; p<=4; p++) {
//					System.out.print(ds[i][j][p]+" ");
//				}
//			}
//			System.out.println();
//		}
		
	}
	private static int simulate() {
		// 1초마다 동시에 상하좌우 인접한 칸 중 하나로 이동 
				// 냄새는 k번 이동뒤에 사라진다
		int time = 0;
		while(q.size() > 1) {
//			if(time == 4) {
//				System.out.println("시작");
//			}
			if(time > 1000)
				return -1;
			//현재 살아있는 상어체크 
//			System.out.println("물고기");
//			for(int i = 0; i< N; i++) {
//				for(int j = 0; j< N; j++) {
//					System.out.print(map[i][j][0]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("방향");
//			for(int i = 0; i< N; i++) {
//				for(int j = 0; j< N; j++) {
//					System.out.print(map[i][j][1]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("가스정보");
//			for(int i = 0; i< N; i++) {
//				for(int j = 0; j< N; j++) {
//					System.out.print(map[i][j][2]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("가스시간");
//			for(int i = 0; i< N; i++) {
//				for(int j = 0; j< N; j++) {
//					System.out.print(map[i][j][3]+" ");
//				}
//				System.out.println();
//			}
			
			int size = q.size();
			// 동시에 움직이므로
			for(int i = 0; i< size;i++) {
				Shark s = q.poll(); // 상어를 빼낸다.
				int row = s.row;
				int col = s.col;
				int num = s.num;
				int dir = map[row][col][1];
				boolean check = false;
				for(int k= 1; k<= 4; k++) {
					int mr = s.row +dr[ds[num][dir][k]];
					int mc = s.col +dc[ds[num][dir][k]];
					if(isIn(mr,mc)) {// 경계체크 
						// 빈칸 체크 
						if(map[mr][mc][3] == 0 && map[mr][mc][0] == 0) // 일단 빈칸 탐색이기때문에 남은시간 정보를 확인
						{
							//가스가 없는 칸이면
							map[s.row][col][0] = 0;
							map[s.row][col][1] = 0;
							map[mr][mc][0] = num;
							map[mr][mc][1] = ds[num][dir][k];
							check = true;
							break;
							//가스는 최종확정후에 넣자 
						}else { // 빈칸이었는데 큐에서 나오는순서때문에 먼저이동한 물고기가 있을 수있음
							if(map[mr][mc][2] == 0) { // 원래 빈곳이었네 
								//물고기 서열 확인
								if(map[mr][mc][0] > num) {
									// 내가 더높네?  -> 덮어씌우기
									map[s.row][col][0] = 0;
									map[s.row][col][1] = 0;
									map[mr][mc][0] = num;
									map[mr][mc][1] = ds[num][dir][k];
									check = true;
									break;
								}else{
									map[s.row][col][0] = 0;
									map[s.row][col][1] = 0;
									check = true;
									break;
								}
							}
						}
						//map[][][] 0은 상어들 1은 현재 방향 2 냄새정보 3 남은시간	
						// 빈칸이 여러개아니면 무조건 자기가 온방향으로 가게 되어있음 
					}
//					ds[][][] //행이 상어번호 뒤가 우선순휘 0~3까지
				} // 빈칸이없었을 경우
				if(!check) {
					for(int k= 1; k<= 4; k++) {
						int mr = s.row +dr[ds[num][dir][k]];
						int mc = s.col +dc[ds[num][dir][k]];
						if(isIn(mr,mc)) {// 경계체크 
							// 빈칸 체크 
							if(map[mr][mc][2] == num) // 일단 빈칸 탐색이기때문에 남은시간 정보를 확인
							{
								q.add(new Shark(num,mr,mc));
								map[s.row][col][0] = 0;
								map[s.row][col][1] = 0;
								map[mr][mc][3] = K+1;
								map[mr][mc][0] = num;
								map[mr][mc][1] = ds[num][dir][k];
								break;
							}
							//map[][][] 0은 상어들 1은 현재 방향 2 냄새정보 3 남은시간	
							// 빈칸이 여러개아니면 무조건 자기가 온방향으로 가게 되어있음 
						}
	//					ds[][][] //행이 상어번호 뒤가 우선순휘 0~3까지
					}
				}
				//
				if(i == size-1) {
					for(int p = 0; p< N; p++) {
						for(int r = 0; r< N; r++) {
							if(map[p][r][0] != 0) {
								if(map[p][r][2] == 0) {
									q.add(new Shark(map[p][r][0], p, r));
									map[p][r][2] = map[p][r][0];
									map[p][r][3] = K+1;
								}
							}
						}
					}
				}
			}
			// 이동후에 냄새처리를 해야함 
			for(int i = 0; i < N; i++) {
				for(int j = 0; j< N; j++) {
					if(map[i][j][3] > 0) {
						map[i][j][3] = map[i][j][3] - 1;
						if(map[i][j][3] == 0) {
							map[i][j][2] = 0;
						}
					}
				}
			}
			time++;
		}
		return time;
				//방향은 
				//1냄새가 없는 칸
				//2.자신의 냄새가 있는칸
				// 가능한칸이 여러개면 특별한 우선순위를 따른다.
				// 상어마다 우선순위가 다를 수 있다.
				// 같은 상어라도 방향따라 다를 수 있다.
//				? 특정한 우선순위 기준이 뭐지? => 우선순위가 입력으로 주어진다.
				// 1 2 3 4 위 아래 왼 오른
				
				
				// 처음에 보고있는 방향은 입력으로 주어지고 
				// 후에는 이동한 방향이 보고있는 방향이 된다
						
						
				//모든상어가 이동후 한칸에 여러마리가 있으면 가장 작은번호 빼고 다 없어짐
						
				// 1번 상어만 남기까지 걸리는 시간 
				// 1000초가 넘어도 다른상어가 있으면 -1 출력
				// t > 1000 => -1
	}
	private static boolean isIn(int mr, int mc) {
		return mr >= 0 && mr < N && mc >= 0 && mc < N;
	}

}
