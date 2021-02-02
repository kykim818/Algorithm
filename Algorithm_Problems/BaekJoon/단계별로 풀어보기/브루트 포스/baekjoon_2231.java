import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2231{
    // 2231 분해합
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);
        int len = input.length();

        int answer = 0;
        for(int i = N - (len * 9); i < N ; i++){
            int tmp = i;
            int sum = i;
            while(tmp != 0){
                sum += tmp % 10;
                tmp /= 10;
            }
            if(sum == N){
                answer = i;
                break;
            } 
        }
        
        System.out.println(answer);
    }
}