import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_10952 {
    // 10952 A+B-5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        while(!(A == 0 && B == 0)){
            bw.write(String.valueOf(A+B)+"\n");
            bw.flush();
            input = br.readLine();
            st = new StringTokenizer(input," ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
        }
        br.close();
        bw.close();
    }
    
}
