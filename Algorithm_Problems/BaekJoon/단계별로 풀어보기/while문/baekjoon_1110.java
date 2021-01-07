import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class baekjoon_1110 {
    // 1110 더하기 사이클
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int A = Integer.parseInt(br.readLine());
        int answer = 1;
        int ten = A / 10; // 10의자리
        int one = A % 10; // 일의자리
        int tmp = one * 10 + ((ten + one) % 10);
        while(A != tmp){
            ten = tmp / 10;
            one = tmp % 10;
            tmp = one * 10 + ((ten + one) % 10);
            answer++;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();

    }
    
}
