import java.io.*;
import java.util.*;

public class baekjoon_1149 {
    // 1149 RGB거리
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int [][] memo = new int[T][3];  // 0 R , 1 G , 2 B 
        int [][] cost = new int[T][3];
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < 3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        memo[0][0] = cost[0][0];
        memo[0][1] = cost[0][1];
        memo[0][2] = cost[0][2];
        int[] tmp = new int[2];
        int idx = 0;
        for(int i = 1; i < T; i++){
            for(int j = 0; j < 3; j++){
                int val = cost[i][j];
                idx = 0;
                for(int p = 0; p < 3; p++){
                    if(p == j) continue;
                    tmp[idx++] = memo[i-1][p];                                    
                }
                memo[i][j] = Math.min(val + tmp[0], val + tmp[1]);
            }    
        }
        int answer = Math.min(memo[T-1][0], memo[T-1][1]);
        answer = Math.min(answer,memo[T-1][2]);
        System.out.println(answer);
    }
    
}
