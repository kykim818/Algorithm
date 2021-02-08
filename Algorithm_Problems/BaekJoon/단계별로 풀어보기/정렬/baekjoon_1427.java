import java.io.*;
import java.util.Arrays;

public class baekjoon_1427 {
    // 1427 소트인사이드

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = new int[input.length()];
        for(int i = 0; i< input.length(); i++){
            arr[i] = input.charAt(i)-'0';
        }
        Arrays.sort(arr);
        int[] reverse = new int[input.length()];
        for(int i = input.length()-1; i >= 0; i--){
            reverse[input.length()-1 - i] = arr[i]; 
        }
        

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            sb.append(reverse[i]);
        }
        System.out.println(Integer.parseInt(sb.toString()));

    }
    
}
