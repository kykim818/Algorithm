import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1011 {
    // 1011 Fly me to the Alpha Centauri
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc= 1; tc<= T; tc++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input," ");
            int start = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());
            int gap = goal - start;
            int answer = 0;
            double tmp1 = Math.sqrt((double) gap);
            // 41  6.xxx
            int idx = (int) tmp1; // 1  =  1.xxx
            if((double) idx == tmp1){ //  제곱수
                answer = idx + idx - 1;
            }else{
                idx++; // 7 
                int std = idx * idx; // 49
                if(std - idx >= gap){
                    answer = idx + idx - 2;
                }else{
                    answer = idx + idx - 1;
                }
                
            } 
            System.out.println(answer);
        }
        
    }
    
    
}
