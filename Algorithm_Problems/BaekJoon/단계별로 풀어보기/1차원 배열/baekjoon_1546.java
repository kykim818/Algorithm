import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.io.BufferedWriter;
// import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_1546 {
    // 1546 평균
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        double max = Double.MIN_VALUE;
        double sum = 0.0;
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," "); 
        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]) max = arr[i];
        }

        for(int i = 0; i < N; i++){
            arr[i] = (arr[i]/max) * 100;
            sum += arr[i];
        }

        System.out.println(sum / N);
        br.close();     
    }
}
