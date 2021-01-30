import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_10872 {
    // 10872 팩토리얼
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        factorial(N,1);
        // 수정
        int result = factorial(N);
        System.out.println(result);
    }
    private static void factorial(int N,int result){
        if(N <= 1){
            System.out.println(result);
            return;
        }
        result *= N;
        factorial(N-1, result);

    }

    private static int factorial(int N){
        if(N == 0){
            return 1;
        }
        return N * factorial(N-1);
    }
}
