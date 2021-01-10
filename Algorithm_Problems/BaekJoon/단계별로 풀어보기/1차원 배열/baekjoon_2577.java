import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon_2577 {
    // 2577 숫자의 개수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        // String result = A*B*C+" ";
        String result = String.valueOf(A*B*C);
        int[] arr = new int[10];
        for(int i = 0; i< result.length(); i++){
            arr[result.charAt(i)-'0']++;
        }        
        for(int i = 0; i < 10; i++){
            bw.write(String.valueOf(arr[i])+"\n");
        }
        br.close();
        bw.flush();
        bw.close();        
    }
}
