import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2292 {
    // 2292 벌집
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int start = 1;
        int idx = 0;
        while(true){
            start += 6*idx;
            idx++;
            if(A <= start){
                break;
            } 
        }
        br.close();
        System.out.println(idx);
    }
    
}
