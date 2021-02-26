import java.io.*;

public class baekjoon_9461{
    // 9461 파도반 수열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] memo = new long[101];
        
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T ; tc++){
            int N = Integer.parseInt(br.readLine());
            DP(N,memo);
            sb.append(memo[N]).append("\n");
        }
        System.out.println(sb);


    }
    public static long DP(int N,long[] memo){
        if(memo[N] > 0){
            return memo[N];
        }
        else if(N <= 3){
            memo[N] = 1;
            return memo[N];
        }else if(N == 4 || N == 5){
            memo[N] = 2;
            return memo[N];
        }else{
            memo[N] = DP(N-1,memo) + DP(N-5,memo);
            return memo[N];
        }
    }
}