import java.util.*;

public class baekjoon_17822_round_board_rotation {
	static int N,M,T; // N개원판 M개수 T개회전
	static int[][][] board;
	static int[][] command;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		board = new int[N+1][M][2];
		command = new int[T][3]; // 0은 판번호 1은 방향 2는 칸수 
		// 1번부터 판의 개수 // M개한이유는 회전했을때 비교학 쉽게 // 0은 원본 1은 인전여부 표시 
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j< M; j++) {
				board[i][j][0] = sc.nextInt();
			}
		}
		
		//명령ㅅ
		for(int i = 0; i < T; i++) {
			for(int j = 0; j <3; j++) {
				command[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i< T; i++) {
			int num = command[i][0];
			int dir = command[i][1];
			int kan = command[i][2];
			simulate(num,dir,kan);
		}
		int answer = 0;
		for(int i= 1; i<= N;i ++) {
			for(int j= 0; j< M; j++) {
				answer += board[i][j][0];
			}
		}
		
		System.out.println(answer);
//		번호가 xi의 배수인 원판을 di방향으로 ki칸 회전시킨다. di가 0인 경우는 시계 방향, 1인 경우는 반시계 방향이다.
//		원판에 수가 남아 있으면, 인접하면서 수가 같은 것을 모두 찾는다.
//		그러한 수가 있는 경우에는 원판에서 인접하면서 같은 수를 모두 지운다.
//		없는 경우에는 원판에 적힌 수의 평균을 구하고, 평균보다 큰 수에서 1을 빼고, 작은 수에는 1을 더한다.
	}
	static boolean check;
	private static void simulate(int num, int dir, int kan) {
		// TODO Auto-generated method stub
		for(int i=1; i<= N; i++) {
			if(i % num == 0) { // 판이 배수면 회전
				if(dir == 0) { //시계방향
					rotateClock(i,kan);
				}else { //반시계
					rotateAntiClock(i,kan);
				}
			}
		}
		print(board);
		// 회전한뒤에 인접한애가 있는지 체크
		check= false;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j< M; j++) {
				checkNear(i,j); 
			}
		}
		
		// 숫자제거
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j< M; j++) {
				if(board[i][j][1] == -1) {
					board[i][j][0] = 0;
				}
			}
		}
		print(board);
		System.out.println(check);
		// 인접여부표시 초기화
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j< M; j++) {
				board[i][j][1] = 0;
			}
		}
		// 인접한애가없으면  원판에 적힌 수의 평균을 구하고, 평균보다 큰 수에서 1을 빼고, 작은 수에는 1을 더한다.
		if(!check) {
			int cnt = 0;
			int sum = 0;
			//일단 평균구하기
			for(int i = 1; i <= N; i++) {
				for(int j = 0; j< M; j++) {
					if(board[i][j][0] != 0) {
						cnt++;
						sum += board[i][j][0];
					}
				}
			}
			double avg =(double)sum / (double)cnt;
			for(int i = 1; i <= N; i++) {
				for(int j = 0; j< M; j++) {
					if(board[i][j][0] != 0) {
						if(board[i][j][0] > avg) {
							board[i][j][0] -=1;
						}else if(board[i][j][0] < avg) {
							board[i][j][0] +=1;
						}
					}
				}
			}
		}
		print(board);
	}
	private static void print(int[][][] board) {
		for(int i = 1; i<= N;i++) {
			for(int j =0; j< M; j++)
				System.out.print(board[i][j][0]+" ");
			System.out.println();
		}
		System.out.println();
	}
	private static void checkNear(int i, int j) {
		// i번쨰판의 j번째수에 인접을 확인한다.
		//1판은 뒤로만 //마지막판은 전판만 확인한다.
		if(board[i][j][0] != 0) {
			if(i == 1) {
				if(board[i][j][0] == board[i+1][j][0]) {
					board[i][j][1] = -1;
					board[i+1][j][1] = -1;
					check =true;
				}
			}else if(i == N) {
				if(board[i][j][0] == board[i-1][j][0]) {
					board[i][j][1] = -1;
					board[i-1][j][1] = -1;
					check = true;
				}
			}else { // 그외의판
				if(board[i][j][0] == board[i+1][j][0]) {
					board[i][j][1] = -1;
					board[i+1][j][1] = -1;
					check = true;
				}
				if(board[i][j][0] == board[i-1][j][0]) {
					board[i][j][1] = -1;
					board[i-1][j][1] = -1;
					check = true;
				}
			}
			// 0번쨰와 M-1 주의 해서 체크
			if(j == 0) {
				if(board[i][j][0] == board[i][j+1][0]) {
					board[i][j][1] = -1;
					board[i][j+1][1] = -1;
					check = true;
				}
				if(board[i][j][0] == board[i][M-1][0]) {
					board[i][j][1] = -1;
					board[i][M-1][1] = -1;
					check = true;
				}
			}else if(j == M-1) {
				if(board[i][j][0] == board[i][j-1][0]) {
					board[i][j][1] = -1;
					board[i][j-1][1] = -1;
					check = true;
				}
				if(board[i][j][0] == board[i][0][0]) {
					board[i][j][1] = -1;
					board[i][0][1] = -1;
					check = true;
				}
			}else { // 그외에는 그냥 양옆비교
				if(board[i][j][0] == board[i][j-1][0]) {
					board[i][j][1] = -1;
					board[i][j-1][1] = -1;
					check = true;
				}
				if(board[i][j][0] == board[i][j+1][0]) {
					board[i][j][1] = -1;
					board[i][j+1][1] = -1;
					check = true;
				}
			}
		}
	}
	private static void rotateClock(int i, int kan) {
		// 시계방향 회전
		for(int q = 0; q < kan; q++) {
			int save = board[i][M-1][0]; // 마지막수
			for(int p = M-2; p >= 0; p--) {
				board[i][p+1][0] = board[i][p][0];
			}
			board[i][0][0] = save;
		}
	}
	private static void rotateAntiClock(int i, int kan) {
		for(int q= 0; q< kan; q++) {
			int save = board[i][0][0];
			for(int p= 1; p< M; p++) {//2번째부터 마지막까지 한칸앞으로 옮김
				board[i][p-1][0] = board[i][p][0];
			}
			board[i][M-1][0] = save;
		}
	}

}
