import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon_8958 {
    // 8958 OX퀴즈 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] sum = new int[N];

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            int idx = 0;
            for(int j = 0 ; j < input.length(); j++){
                if(input.charAt(j) == 'O'){
                    idx++;
                    sum[i] += idx;
                }else{
                    idx = 0;
                }
            }
        }

        for(int i = 0; i < N; i++){
            bw.write(sum[i]+"\n");
        }
        
        bw.flush();
        br.close();    
        bw.close();
    }
}
