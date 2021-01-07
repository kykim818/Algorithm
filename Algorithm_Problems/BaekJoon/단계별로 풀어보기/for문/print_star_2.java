import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class print_star_2 {
    // 2439 별찍기 - 2
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N ; i++){
            for(int j = N-i; j>=1; j--){
                sb.append(" ");
            }
            for(int j = 1; j <= i; j++){
                sb.append("*");
            }
            bw.write(sb.toString());
            bw.write("\n");
            sb.setLength(0);
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
