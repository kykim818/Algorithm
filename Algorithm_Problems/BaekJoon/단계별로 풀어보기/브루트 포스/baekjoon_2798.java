import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class baekjoon_2798 {
    // 2798 블랙잭
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," ");
        int N = Integer.parseInt(st.nextToken()); // 카드장
        int M = Integer.parseInt(st.nextToken()); // 합
        int[] arr = new int[N];
        int[] res = new int[3];
        input = br.readLine();
        st = new StringTokenizer(input," ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 순서 상관없이 3장고르기 -> 조합 
        combination(arr,res,0,0,0,M);

        System.out.println(answer);
    }
    
    private static void combination(int[] arr,int[] res,int arr_idx,int res_idx,int sum,int goal){
        if(sum > goal) return;
        if(res_idx == res.length){
            answer = Math.max(answer, sum);
            return;
        }
        if(arr_idx == arr.length) return;

        res[res_idx] = arr[arr_idx];
        combination(arr, res, arr_idx+1, res_idx+1,sum+arr[arr_idx],goal);
        combination(arr, res, arr_idx+1, res_idx, sum, goal);
    }
}
