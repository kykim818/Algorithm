import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1978 {
    // 1978 소수찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," ");
        int answer = 0;
        for(int i = 0; i < N ; i++){
            int A = Integer.parseInt(st.nextToken());
            int idx = 2;
            
            while(A > 1){
                if(idx == A){
                    answer++;
                    break;
                }

                if(A % idx == 0){
                    break;
                }
                idx++;
            }
        }
        System.out.println(answer);
    }
    
}
