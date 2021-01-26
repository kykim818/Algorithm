import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_4948 {
    // 4948 베르트랑 공준
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            boolean[] check = new boolean[2*N+1];
            // 에라토스테네스의 체
            check[1] = true;
            for(int i = 2; i <= 2*N; i++){
                int start = i+i;
                while(start <= 2*N){
                    if(check[start] == false){
                        check[start] = true;
                    }
                    start += i;
                }
            }

            int answer = 0;
            for(int i = N+1; i <= 2*N; i++){
                if(check[i] == false) answer++;
            }
            System.out.println(answer);
        }

    }
    
}
