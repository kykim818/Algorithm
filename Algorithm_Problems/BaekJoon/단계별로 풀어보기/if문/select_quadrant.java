import java.io.*;

public class select_quadrant {
    // 14681 사분면고르기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int answer = 0;
        if(A > 0){
            if(B > 0) answer = 1;
            else answer = 4;
        }else{
            if(B > 0) answer = 2;
            else answer = 3;
        }
        System.out.println(answer);
    }

}
