import java.io.*;

public class baekjoon_1003 {
    // 1003 피보나치 함수
    static int cnt = 0;
    static int cnt1 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] memo = new int[41][3];
        memo[0][0] = 0;
        memo[0][1] = 1;
        memo[0][2] = 0;
        memo[1][0] = 1;
        memo[1][1] = 0;
        memo[1][2] = 1;
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            int[] answer = fibo(N,memo);
            sb.append(answer[1]).append(" ").append(answer[2]).append("\n");
        }
        System.out.println(sb);

    }
    public static int[] fibo(int N,int[][] memo){
        if(memo[N][0] > 0){
            return memo[N];
        }
        else if(N == 0){
            return memo[0];
        }
        else if(N == 1){
            return memo[1];
        }
        else{
            memo[N-1] = fibo(N-1, memo);
            memo[N-2] = fibo(N-2, memo);
            for(int i = 0; i < 3; i++){
                memo[N][i] = memo[N-1][i] + memo[N-2][i];
            }
            return memo[N];
        }
    }

}
