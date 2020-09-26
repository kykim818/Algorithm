import java.util.*;


public class baekjoon_17779_gerrymandering2 {
	static int N;
	static int[][] map;
	static int[][] region;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i = 0; i< N; i++) {
			for(int j = 0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 맵입력 
		int[] arr = new int[N-1];
		for(int i = 0; i < N-1; i++) {
			arr[i] = i+1;
		}
		//일단 가능한 d1,d2의 조합을 다뽑아서 정하고 들어가자
		for(int d1 = 1; d1 <= N-1; d1++) {
			for(int d2= 1; d2<= N-1; d2++) {
				// 여기서 다시 맵탐색 
				if(d1+d2 > N)
					continue;
				
				region = new int[N][N];
				// 기준점 정하기
				for(int x =1; x<= N-(d1+d2); x++) {
					for(int y= 1+d1; y<=N-d2; y++) {
						//기준점을 정했으니까 기준점과 d1,d2를 가지고 맵구역을 나누자!
						int[] region_cnt = new int[5];
						System.out.println("x :"+x+"y : "+y+" d1 : "+d1+" d2: "+ d2);
						for(int r = 0; r < N; r++) {
							for(int c = 0; c < N; c++) {
//								1번 선거구: 0 ≤ r < x+d1-1, 0 ≤ c ≤ y-1
								if(0 <= r && r < x+d1-1 && 0<= c && c <= y-1) {
									region[r][c] = 1;
									region_cnt[0] += map[r][c];	
								}
//								2번 선거구: 0 ≤ r ≤ x+d2-1, y-1 < c ≤ N-1
								else if(0 <= r && r <= x+d2-1 && y-1 < c && c <= N-1) {
									region[r][c] = 2;
									region_cnt[1] += map[r][c];
								}
//								3번 선거구: x+d1-1 ≤ r ≤ N-1, 0 ≤ c < y-d1+d2-1
								else if(x+d1-1 <= r && r <= N-1 && 0 <= c && c < y-d1+d2-1) {
									region[r][c] = 3;
									region_cnt[2] += map[r][c];
								}
//								4번 선거구: x+d2-1 < r ≤ N-1, y-d1+d2-1 ≤ c ≤ N-1	
								else if(x+d2-1 < r && r <= N-1 && y-d1+d2-1 <= c && c <= N-1) {
									region[r][c] = 4;
									region_cnt[3] += map[r][c];
								}
								else {
									region[r][c] = 5;
									region_cnt[4] += map[r][c];
								}
							}
						}
						// 정렬
						for(int i = 0 ; i< N; i++) {
							System.out.println(Arrays.toString(region[i]));
						}
						System.out.println();
						
						Arrays.sort(region_cnt);
						answer = Math.max(answer, region_cnt[4]-region_cnt[0]);
					}
				}
			}
			//
		}
		System.out.println(answer);
		//d1, d2 ≥ 1
		//1 ≤ x < x+d1+d2 ≤ N,
		// 1 <= x <= N-2 
		//
		//1 ≤ y-d1 < y < y+d2 ≤ N
		//1 <= y-d1 < y < y+d2 <= N
		//1+d1 <= y < y+d1 // 
		// 2 <= y <= N-1(d2)  
		
		
	
	}

}
