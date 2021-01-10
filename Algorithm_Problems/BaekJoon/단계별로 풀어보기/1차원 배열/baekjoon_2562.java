import java.io.*;

public class baekjoon_2562 {
    // 2562 최댓값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = Integer.MIN_VALUE;
        int idx = 0;
        int[] arr = new int[9];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]> max){
                max = arr[i];
                idx = i+1;
            }
        }
        bw.write(String.valueOf(max)+"\n"+String.valueOf(idx));
        br.close();
        bw.flush();
        bw.close();


    }
    
}
