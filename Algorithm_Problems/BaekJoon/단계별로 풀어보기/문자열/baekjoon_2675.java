import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2675 {
    // 2675 문자열반복
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc<= T; tc++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input," ");
            int cnt = Integer.parseInt(st.nextToken());

            String word = st.nextToken();
            for(int i = 0; i < word.length(); i++){
                for(int j = 0; j < cnt; j++){
                    sb.append(word.charAt(i));
                }
            }
            
            System.out.println(sb.toString());
            sb.setLength(0);
        }
        br.close();
    }
    
}
