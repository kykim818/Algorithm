import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2775 {
    // 2775 부녀회장일 될테야
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<= T; tc++){
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호
            int num = answer(k,n);
            System.out.println(num);
        }// end of case
    }
    private static int answer(int k, int n){
        if(n == 1)
            return 1;
        else if(k == 0)
            return n;
        else
            return answer(k,n-1) + answer(k-1,n);

    }
}
