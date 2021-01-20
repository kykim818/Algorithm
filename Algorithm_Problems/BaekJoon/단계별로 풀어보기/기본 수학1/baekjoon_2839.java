import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2839 {
    // 2839 설탕배달
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = N / 5;
        if( N % 5 != 0){
            N %= 5;
            while(true){
                if( N % 3 == 0){
                    answer += N / 3;
                    break;
                }else{
                    if(answer == 0){
                        answer = -1;
                        break;
                    }
                    answer--;
                    N += 5;
                }
            }
        }
        System.out.println(answer);
        


    }
    
}
