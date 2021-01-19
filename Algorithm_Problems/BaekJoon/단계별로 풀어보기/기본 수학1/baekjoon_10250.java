import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class baekjoon_10250 {
    // 10250 ACM호텔
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T= Integer.parseInt(br.readLine());
        for(int tc = 1; tc<= T; tc++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input," ");
            int H = Integer.parseInt(st.nextToken()); // 층수
            int W = Integer.parseInt(st.nextToken()); // 방수
            int N = Integer.parseInt(st.nextToken()); // 몇번째 손님

            int x = N % H != 0 ? N/H + 1 : N/H;
            int y = N % H == 0 ? H : N % H;

            //int x = N % H != 0 ? N/H + 1 : N/H;
            //int y = N % H;
            // 나머지를 구하는 식을 쓸때는 나누는수가 1인경우와 나머지가 0인경우를 생각해보자
            
            StringBuilder sb = new StringBuilder();
            sb.append(y);
            if(x < 10){
                sb.append(0).append(x);
            }else{
                sb.append(x);
            }
            System.out.println(sb.toString());



        }// end of case


    }
    
}
