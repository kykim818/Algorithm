import java.util.*;
import java.io.*;


public class baekjoon_15651 {
    // 15651 N과 M (3)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] res = new int[M];
        backTracking(0,N,res);
        System.out.println(sb);
    }
    static StringBuilder sb  = new StringBuilder();
    static private void backTracking(int res_idx,int N,int[] res){
        if(res_idx == res.length){
            for(int i = 0; i < res.length; i++){
                sb.append(res[i]).append(' ');
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            res[res_idx] = i;
            backTracking(res_idx+1, N, res);
        }
    }
}
