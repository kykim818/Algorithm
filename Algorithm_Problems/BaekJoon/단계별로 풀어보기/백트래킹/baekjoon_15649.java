import java.util.*;
import java.io.*;


public class baekjoon_15649 {
    // 15649 N과M(1)
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        boolean[] check = new boolean[N];
        int[] res = new int[M];

        for(int i = 0; i < N; i++){
            arr[i] = i+1;
        }
        backTracking(0,arr,res,check);
        System.out.println(sb);
    }
    static StringBuilder sb = new StringBuilder();
    static private void backTracking(int res_idx,int[] arr,int[] res,boolean[] check){
        if(res_idx == res.length){
            System.out.println(Arrays.toString(res));
            for(int i = 0; i < res.length; i++){
                sb.append(res[i]).append(" ");    
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(!check[i]){
                res[res_idx] = arr[i];
                check[i] = true;
                backTracking(res_idx+1, arr, res, check);
                check[i] = false;
            }
        }        
    }    
}
