import java.util.Arrays;

public class kakao_blind_2020_lock_and_key {
	static int n;
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
		int[][] keycase = new int[n][n];
		for(int i = 0; i < 4 ; i++) { // 0 그대로 // 1일떄 90 2 180 3 270
			keycase = rotateKey(key,i);
			
		}
//		keycase = rotateKey(key,3);
		for(int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(keycase[i]));
		}
		
		
//		key는 M x M(3 ≤ M ≤ 20, M은 자연수)크기 2차원 배열입니다.
//		lock은 N x N(3 ≤ N ≤ 20, N은 자연수)크기 2차원 배열입니다.
//		M은 항상 N 이하입니다.
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
