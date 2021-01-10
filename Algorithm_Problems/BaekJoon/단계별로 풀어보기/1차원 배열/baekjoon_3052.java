import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon_3052 {
    // 3052 나머지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = new int[42];
        int input = 0;
        for(int i = 0; i < 10; i++){
            input = Integer.parseInt(br.readLine());
            arr[input % 42]++;
        }
        int answer = 0;
        for(int val : arr){
            if(val != 0) answer++;
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();

        br.close();
        bw.close();
    }
}
