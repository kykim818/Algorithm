import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class number_smaller_than_X {
    // 10871 X보다 작은 수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," ");
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        String nums = br.readLine();
        st =new StringTokenizer(nums," ");
        for(int i = 1; i <= N; i++){
            int A = Integer.parseInt(st.nextToken());
            if(X>A){
                bw.write(String.valueOf(A)+" ");
            }
        }
        bw.flush();
        br.close();
        bw.close();
        
    }
}
