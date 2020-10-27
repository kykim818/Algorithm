
public class programmers_divde_N {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int number = 12;
		int answer = -1;
		int[] memo= new int[number+1];
		if(N == 1) {
			if(number <= 8)
				answer = number;
		}else {
			memo[0] = 2;
			memo[1] = 2;
			for(int i = 2; i <= number; i++) {
				if(i == N) {
					memo[i] = 1;
				}else if(i % N == 0) {
					memo[i] = i/N * memo[N];
				}else if(i < N) {
					memo[i] = i+1;
				}else {
					memo[i] = i/N * memo[N]+ memo[i % N];
				}
			}
			answer = memo[number];
		}
		System.out.println(answer);
	}

}
