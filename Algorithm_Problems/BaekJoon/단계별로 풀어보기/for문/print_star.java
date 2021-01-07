import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class print_star {
    // 2438 별찍기 - 1
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        try{
            int N = Integer.parseInt(br.readLine());
            for(int i = 1; i<= N; i++){
                sb.append("*");
                bw.write(sb.toString());
                bw.newLine();
            }
            bw.flush();
            br.close();
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
