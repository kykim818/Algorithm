import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class fast_A_plus_B {
    // 15552 빠른 A+B
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc= 1; tc <= T; tc++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input," ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // bw.write(A+B);
            bw.write(String.valueOf(A+B));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
