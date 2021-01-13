import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2908 {
    // 2908 상수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," ");
        String A = st.nextToken();
        String B = st.nextToken();
        StringBuilder sb = new StringBuilder();
        for(int i = A.length()-1; i >= 0; i--){
            sb.append(A.charAt(i));
        }
        int num1 = Integer.parseInt(sb.toString());
        sb.setLength(0);
        for(int i = B.length()-1; i >= 0; i--){
            sb.append(B.charAt(i));
        }
        int num2 = Integer.parseInt(sb.toString());
        System.out.println(num1 > num2 ? num1 : num2);


    }
}
