import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class baekjoon_10809 {
    // 10809 알파벳찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] list = new int[26];
        Arrays.fill(list, -1);
        
        for(int i = 0; i < input.length(); i++){
            if(list[input.charAt(i)-'a'] == -1){
                list[input.charAt(i)-'a'] = i;
            }
        }
        for(int i = 0; i < list.length; i++){
            System.out.printf(list[i]+" ");
        }
    }
    
}
