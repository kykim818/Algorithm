import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_10989 {
    // 10989 수 정렬하기 3
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ori = new int[N];
        int[] sorted = new int[N+1];
        // 원배열
        int[] cnt = new int[10001];
        for(int i = 0; i< N; i++){
            ori[i] = Integer.parseInt(br.readLine());
            cnt[ori[i]]++;
        }
        // 누적합 배열로만들기
        int sum = 0;
        for(int i = 0; i< 10001; i++){
            if(cnt[i] !=0){
                cnt[i] += sum;
                sum = cnt[i];
            }
        }

        // 배열 역순 참조
        int idx = 0;
        for(int i = N-1; i >=0 ; i--){
            idx = cnt[ori[i]];
            sorted[idx] = ori[i];
            cnt[ori[i]]--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(sorted[i]).append("\n");
        }

        System.out.println(sb);
    }
    
}
