import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2750 {
    // 2750 수 정렬하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        int tmp = 0;
        for(int i= N-1; i > 0; i--){
            for(int j = 0 ; j< i; j++){
                if(arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        for(int i = 0; i < N; i++){
            System.out.println(arr[i]);
        }
    }
    
}
