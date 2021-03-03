import java.util.*;
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
        DP(N,memo,score);
        
    }
    public static int[] DP(int N, int[][] memo, int[] score){
        if(N == 0){
            memo[N][0] = score[0];
            memo[N][1] = score[0];
            return memo[N];
        }

        memo[N][0] = DP(N-1)
    }
}
