import java.io.IOException;
import java.io.*;

public class yun_year {
    // 2753 윤년
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int result = 0;
        if(input % 400 == 0) result = 1;
        else if(input % 4 == 0 && input % 100 != 0) result = 1;

        System.out.println(result);
    }
}
