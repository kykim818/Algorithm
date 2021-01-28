import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1085 {
    // 1085 직사각형에서 탈출
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;
        answer = Math.min(answer, x);
        answer = Math.min(answer, y);
        answer = Math.min(answer, w-x);
        answer = Math.min(answer, h-y);

        System.out.println(answer);
        
                
    }
    
}
