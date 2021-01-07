import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A_plus_B_7 {
    // 11021 A+B-7
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input," ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bw.write("Case #" + String.valueOf(tc) + ": "+String.valueOf(A+B)+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
