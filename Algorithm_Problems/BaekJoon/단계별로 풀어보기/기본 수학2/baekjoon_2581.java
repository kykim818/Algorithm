import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2581 {
    // 2581 소수
    static int min = Integer.MAX_VALUE;
    static int sum = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        for(int i = M; i <= N; i++){
            checkPrime(i);
        }
        if(sum == 0) System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
    private static void checkPrime(int num){
        if(num <= 1) return;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return;
        }
        min = Math.min(min, num);
        sum += num;
    }
    
}
