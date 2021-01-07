import java.io.*;

public class print_N_reverse {
    // 2742 기찍 N
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i = N; i >= 1; i--){
            bw.write(String.valueOf(N--));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
}
