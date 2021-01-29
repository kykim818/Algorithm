import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_4153 {
    // 4153 직각삼각형
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," ");
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while(!(arr[0] == 0 && arr[1] == 0 && arr[2] == 0)){
            Arrays.sort(arr);
            if((arr[0]*arr[0]) + (arr[1] * arr[1]) == arr[2] * arr[2]){
                sb.append("right").append("\n");
            }else{
                sb.append("wrong").append("\n");
            }

            input = br.readLine();
            st = new StringTokenizer(input," ");
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }
}
