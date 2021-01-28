import java.io.BufferedReader;
import java.io.IOException;


public class baekjoon_9020 {
    // 9020 골드바흐의 추측
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[10001];
        check[1] = true;
        int start = 0;
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 2;  i <= 100; i++){
            start = i;
            idx = 2;
            while(start * idx <= 10000){
                if(check[start*idx] == false) check[start*idx] = true;
                idx++;
            }
        }

        for(int tc = 1; tc<= T; tc++){
            int n = Integer.parseInt(br.readLine()); // 4 <= n <= 10000
            for(int i = n/2; i >= 2; i--){
                if(check[i] == false && check[n-i] == false){
                    sb.append(i).append(" ").append((n-i)).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
