import java.util.*;
import java.io.*;

public class baekjoon_1932 {
    // 1932 정수 삼각형
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][N];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < i; j++){
                input[i-1][j] = Integer.parseInt(st.nextToken());
            }
        }
        int [][] memo = new int[N][N];
        int a = 0;
        int b = 0;
        memo[0][0] = input[0][0];
        for(int i = 1; i < N ; i++){ //층
            for(int j = 0; j <= i; j++){ //층별개수
                // 1 0 0 0
                a = 0;
                b = 0;
                if(j <= i-1){
                    a = input[i][j] + memo[i-1][j];
                }
                if(j-1 >= 0){
                    b = input[i][j] + memo[i-1][j-1];
                }
                memo[i][j] = Math.max(a, b);
            }
        }
        int answer = 0;
        
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(memo[i]));
            // answer = Math.max(answer, memo[N-1][i]);
        }

        System.out.println(answer);
    }
    
}
