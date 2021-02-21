import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_10870 {
    // 10870 피보나치 수 5
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
        // memo = new int[n+1];
        // System.out.println(Arrays.toString(memo));
        // fibo(n);
    }
    // static int[] memo;
    private static int fibo(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibo(n-1) + fibo(n-2);
    }


    // 동적계획법
    // private static int fibo(int n){
    //     if(memo[n] > 0){
    //         return memo[n];
    //     }else if(n == 1){
    //         memo[1] = 0;
    //         return 0;
    //     }else if(n == 2){
    //         memo[2] = 1;
    //         return 1;
    //     }else{
    //         memo[n] = fibo(n-1) + fibo(n-2);
    //         return memo[n];
    //     }
    // }
}
