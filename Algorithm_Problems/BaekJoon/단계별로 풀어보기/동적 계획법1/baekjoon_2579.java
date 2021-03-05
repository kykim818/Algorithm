import java.io.*;

public class baekjoon_2579 {
    // 2579 계단오르기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        for(int i = 0; i < N; i++){
            score[i] = Integer.parseInt(br.readLine());
        }
        int[][] memo = new int[N][2];
        memo[0][0] = score[0];
        memo[0][1] = score[0];
        if(N >= 2){
            memo[1][0] = memo[0][0] + score[1];
            memo[1][1] = score[1];
        }

        for(int i = 2; i < N; i++){
            memo[i][0] = memo[i-1][1] + score[i];
            memo[i][1] = Math.max(memo[i-2][0], memo[i-2][1]) + score[i];
        }
        
        System.out.println(Math.max(memo[N-1][0], memo[N-1][1]));
        // 0 이전계단 밟기
        // 1 이전계단 안밟고 두계단 전꺼 밟기 
    }
    
}
