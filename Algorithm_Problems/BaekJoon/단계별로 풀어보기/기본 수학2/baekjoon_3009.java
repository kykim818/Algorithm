import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_3009 {
    // 3009 네번째 점
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," ");
        
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        input = br.readLine();
        st = new StringTokenizer(input," ");

        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        input = br.readLine();
        st = new StringTokenizer(input," ");

        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        if(x1 == x2 || y1 == y2){
            if(x1 == x3 || y1 == y3){
                System.out.println((x2+x3-x1)+" "+(y2+y3-y1));
            }else{
                System.out.println((x1+x3-x2)+" "+(y1+y3-y2));
            }
        }else{
            System.out.println((x1+x2-x3)+" "+(y1+y2-y3));
        }
    }
    
}
