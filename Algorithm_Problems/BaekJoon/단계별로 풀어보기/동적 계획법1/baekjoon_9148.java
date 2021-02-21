import java.util.*;
import java.io.*;


public class baekjoon_9148 {
    // 9184 신나는 함수 실행
    static int[][][] memo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 0;
        int b = 0;
        int c = 0;
        memo = new int[51][51][51]; // -50 = 0 0 50 50 = 100
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            if(a == -1 && b == -1 && c == -1)
                break;
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c)).append("\n");                
        }
        System.out.println(sb);
    }
    public static int w(int a,int b,int c){
        if( a <= 0 || b <= 0 || c <= 0){
            return 1;
        }
        else if(memo[a][b][c] > 0 ){
            return memo[a][b][c];
        }
        else if( a > 20 || b > 20 || c > 20){
            return w(20,20,20);
        }
        else if( a < b && b < c ){
            memo[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
            return memo[a][b][c]; 
        }
        else{
            memo[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1); 
            return memo[a][b][c];
        }
    }
}
