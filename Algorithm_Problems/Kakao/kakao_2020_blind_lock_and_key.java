import java.util.Arrays;

public class kakao_blind_2020_lock_and_key {
	static int n,m;
	static boolean check;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		boolean answer = false;
		
		// idea : 완탐  
		// M이 최대가 N이랑 같을때 
		
		//회전은 3번하면 전부 다보는거임 방향상관없이 4번쨰는 원위치로 돌아오니까
		//회전했을떄
		//방향별로 n-1칸씩 최대 이동할수잇음 그이상이동하면 열쇠칸을 벗어남 
		// 00 기준
		n = key.length;
		m = lock.length;
		int cnt = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				if(lock[i][j] == 0) cnt++;
			}
		}
		
		check = false;
		int[][] keycase = new int[n][n];
		L : for(int i = 0; i < 4 ; i++) { // 0 그대로 // 1일떄 90 2 180 3 270
			keycase = rotateKey(key,i);
			//위 , 좌상 우상 체크
			for(int k = 0 ; k <= m-1; k++) {
				for(int l = 0; l <= m-1; l++) {
					answer = matching(keycase,lock,k,l,0,cnt);
					if(answer == true) break L; 
				}
				for(int r = 0; r <= m-1; r++) {
					answer = matching(keycase,lock,k,r,1,cnt);
					if(answer == true) break L; 
				}
			}
			//아래 , 
			for(int k = 0 ; k <= m-1; k++) {
				for(int l = 0; l <= m-1; l++) {
					answer = matching(keycase,lock,k,l,2,cnt);
					if(answer == true) break L; 
				}
				for(int r = 0; r <= m-1; r++) {
					answer = matching(keycase,lock,k,r,3,cnt);
					if(answer == true) break L; 
				}
			}
		}
		System.out.println(answer);
		
		
//		key는 M x M(3 ≤ M ≤ 20, M은 자연수)크기 2차원 배열입니다.
//		lock은 N x N(3 ≤ N ≤ 20, N은 자연수)크기 2차원 배열입니다.
//		M은 항상 N 이하입니다.
	}
	private static boolean matching(int[][] keycase, int[][] lock, int tb, int lr, int dir, int cnt) {
		boolean match = false;
		int tbDir = 0;
		int lrDir = 0;
		switch(dir){
			case 0: // 상 좌
				tbDir = -1;
				lrDir = -1;
				break;
			case 1: // 상 우
				tbDir = -1;
				lrDir = 1;
				break;
			case 2: // 하 좌
				tbDir = 1;
				lrDir = -1;
				break;
			case 3: // 하 우
				tbDir = 1;
				lrDir = 1;
				break;
		}
		// keycase를 이동시키면서 매칭 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int mov_row = i + tbDir * tb;
				int mov_col = j + lrDir * lr;
				if(isIn(mov_row,mov_col)) {
					if(keycase[i][j] == 1 && lock[mov_row][mov_col] == 1) {
						return false;
					}
					if(keycase[i][j] == 0 && lock[mov_row][mov_col] == 0) {
						return false;
					}
					if(keycase[i][j] == 1 && lock[mov_row][mov_col] == 0) {
						cnt--;
					}
				}
			}
		}
		if(cnt == 0) match = true;
		return match;
	}
	private static boolean isIn(int mov_row, int mov_col) {
		// TODO Auto-generated method stub
		return mov_row >= 0 && mov_row < m && mov_col >=0 && mov_col < m;
	}
	private static int[][] rotateKey(int[][] key, int i) {
		int[][] ret = new int[n][n];
		switch(i) {
			case 0 :
				for(int p = 0; p< n; p++) {
					for(int q = 0; q< n; q++) {
						ret[p][q] = key[p][q];
					}
				}
				break;
			case 1 : // 90 도회전 
				for(int p = 0; p < n; p++) {
					for(int q = 0; q< n; q++) {
						ret[p][q] = key[n-1-q][p];
					}
				}
				break;
			case 2 : // 180도
				for(int p = 0; p < n; p++) {
					for(int q = 0; q< n; q++) {
						ret[p][q] = key[n-1-p][n-1-q];
					}
				}
				break;
			case 3 : // 270
				for(int p = 0; p < n; p++) {
					for(int q = 0; q< n; q++) {
						ret[p][q] = key[q][n-1-p];
					}
				}
				break;
			
		}
		return ret;
	}

}
