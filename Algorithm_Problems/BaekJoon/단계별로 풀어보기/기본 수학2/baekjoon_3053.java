import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_3053{
    // 3053 택시 기하학
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());

        System.out.printf("%.6f\n",Math.PI * r * r);
        System.out.printf("%.6f\n",(double)(2 * r * r));


    }
}