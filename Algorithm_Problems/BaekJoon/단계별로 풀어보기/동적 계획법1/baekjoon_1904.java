import java.io.*;


public class baekjoon_1904 {
    // 1904. 01타일 
    static final int mod = 15746;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] memo = new int[1000001];
        memo[1] = 1; // 1
        memo[2] = 2; // 00 11
        for(int i = 3; i <= N; i++){
            memo[i] = (memo[i-1] + memo[i-2]) % mod;
        }
        System.out.println(memo[N]);        

    }
}
