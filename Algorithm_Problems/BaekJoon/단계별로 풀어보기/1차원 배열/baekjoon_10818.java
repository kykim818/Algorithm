import java.io.*;
import java.util.Arrays;

public class baekjoon_10818 {
    // 10818 최소, 최대
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String input = br.readLine();
        // StringTokenizer st = new StringTokenizer(input," ");
        String[] strings = input.split("\\s");
        int[] arr = Arrays.asList(strings).stream().mapToInt(Integer::parseInt).toArray();
        for(int i = 0; i < N; i++){
            if(arr[i]> max){
                max = arr[i];
            }

            if(arr[i]< min){
                min = arr[i];
            }
        }
        bw.write(String.valueOf(min)+" "+String.valueOf(max));
        br.close();
        bw.flush();
        bw.close();
    }
}
