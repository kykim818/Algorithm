import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_4344 {
    // 4344 평균은 넘겠지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        double[] pos = new double[T];
        for(int tc = 1; tc<= T; tc++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input," ");
            int N = Integer.parseInt(st.nextToken());
            int[] score = new int[N];
            int sum = 0;
        
            for(int i = 0; i < N; i++){
                score[i] = Integer.parseInt(st.nextToken());
                sum += score[i];
            }

            int avg = sum / N ;
            int cnt = 0;

            for(int i = 0; i < N; i++){
                if(avg < score[i]){
                    cnt++;
                }
            }
            pos[tc-1] = (double) cnt / (double) N * 100;
        }
        for(int i = 0; i < T ; i++){
            System.out.printf("%.3f%%\n",pos[i]);
        }
    }
}
