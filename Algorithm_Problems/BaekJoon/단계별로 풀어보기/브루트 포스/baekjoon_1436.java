import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1436 {
    // 1436 영화감독 숌
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int idx = 0;
        int start = 666;
        String val = null;
        while(true){
            val = String.valueOf(start);
            if(val.contains("666")){
                idx++;
            }

            if(idx == N) break;
            start++;
            
        }
        System.out.println(start);
    }
}
