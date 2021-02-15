import java.util.*;
import java.io.*;


public class baekjoon_14888 {
    // 14888 연산자 끼워넣기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] res = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        // + - * /
        int[] cnt = new int[4];
        for(int i = 0; i < 4; i++){
            cnt[i] = Integer.parseInt(st.nextToken());
        }
        backTracking(0,arr,res,cnt);
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    private static void backTracking(int res_idx,int[] arr,int[] res,int[] cnt){
        if(res_idx == res.length){
            int ret = arr[0];
            int idx = 1;
            int op = 0;
            for(int i = 0 ; i < res.length; i++){
                op = res[i];
                if(op == 0) ret += arr[idx];
                else if(op == 1) ret -= arr[idx];
                else if(op == 2) ret *= arr[idx];
                else{
                    if(ret < 0){
                        ret = Math.abs(ret);
                        ret /= arr[idx];
                        ret *= -1;
                    }else{
                        ret /= arr[idx];
                    }
                }
                idx++;    
            }
            max = Math.max(max, ret);
            min = Math.min(min, ret);
            return;
        }
        for(int i = 0; i < 4; i++){
            if(cnt[i] > 0){
                res[res_idx] = i;
                cnt[i]--;
                backTracking(res_idx+1, arr, res, cnt);
                cnt[i]++;
            }
        }

    }
}
