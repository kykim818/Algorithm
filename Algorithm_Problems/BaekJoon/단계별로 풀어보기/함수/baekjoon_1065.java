import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class baekjoon_1065 {
    // 1065 한수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 1 ; i<= N; i++){
            cnt += check(i);
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        
    }

    private static int check(int i){
        if(i < 100) return 1;
        //100보다 크면 
        int a = i % 10;
        i /= 10;
        int b = i % 10;
        int gap = a-b;
        while(i != 0){
            a = b;
            i /= 10;
            b = i % 10;
            if(a-b != gap) return 0;
            if(i < 10) break;
        }
        return 1;
    }
}
