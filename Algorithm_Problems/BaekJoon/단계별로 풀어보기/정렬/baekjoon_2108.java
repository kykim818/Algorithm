import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class baekjoon_2108{
    // 2108 통계학

    static class Num implements Comparable<Num>{
        int val,cnt;
        Num(int val,int cnt){
            this.val = val;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Num o){
            return this.cnt - o.cnt;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] cnt = new int[8001];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            cnt[arr[i]+4000]++;
        }

        StringBuilder sb = new StringBuilder();
        // 산술평균
        double avg = 0.0;
        int sum = 0;
        for(int val : arr){
            sum += val;
        }
        avg = (double) sum / N;
        sb.append(Math.round(avg)).append("\n");

        // 중앙값 , N이 홀수임 
        Arrays.sort(arr);
        sb.append(arr[(N/2 + 1) - 1]).append("\n");

        // 최빈값
        ArrayList<Num> list = new ArrayList<>();
        for(int i = 0; i <= 8000; i++){
            if(cnt[i] != 0){
                list.add(new Num(i,cnt[i]));
            }
        }
        Collections.sort(list);
        int len = list.size();
        int max_cnt = list.get(len-1).cnt;
        for(int i = 0; i < len ; i++){
            if(list.get(i).cnt == max_cnt){
                if(i == len-1){
                    sb.append(list.get(len-1).val - 4000).append("\n");     
                }else{
                    sb.append(list.get(i+1).val - 4000).append("\n");
                }
                break;
            } 
        }
        // 범위
        sb.append(arr[N-1] - arr[0]).append("\n");

        System.out.println(sb);
    }
}