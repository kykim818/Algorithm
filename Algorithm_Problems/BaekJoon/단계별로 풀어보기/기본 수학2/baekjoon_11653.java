import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_11653 {
    // 11653 소인수분해
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N != 1){
            for(int i = 2; i*i<= N; i++){
                if(N % i == 0){
                    System.out.println(i);
                    N /= i;
                    i = 1;
                }
            }
            // 소수인 경우
            if(N != 1) System.out.println(N);
            break;
        }


    }
}
