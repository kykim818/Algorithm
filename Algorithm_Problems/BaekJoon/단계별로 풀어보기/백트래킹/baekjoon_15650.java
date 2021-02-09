import java.util.*;
import java.io.*;


public class baekjoon_15650 {
    // N과 M(2)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] res = new int[M];
        boolean[] check = new boolean[N+1];

        backTracking(0,res,check);
        System.out.println(sb);
    }
    static StringBuilder sb = new StringBuilder();
    static private void backTracking(int res_idx,int[] res,boolean[] check){
        if(res_idx == res.length){
            for(int i = 0; i < res.length; i++){
                sb.append(res[i]).append(' ');
            }
            sb.append("\n");
            return;
        }

        for(int i = 1 ; i <= check.length-1; i++){
            if(check[i] == false){
                if(res_idx == 0 || i > res[res_idx-1]){
                    res[res_idx] = i;
                    check[i] = true;
                    backTracking(res_idx+1, res, check);
                    check[i] = false;
                }
            }
        }
    }
}
