import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1152 {
    // 1152 단어의 개수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean space = true;
        int cnt = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ' '){
                space = true;
            }
            if(input.charAt(i) >= 'A'){
                if(space){
                    cnt++;
                    space = false;
                }
            }
        }
        System.out.println(cnt);
        
        
        
        // String[] list = input.split("\\s");
        // if(input.charAt(0) == ' ' && list.length != 0){
        //     System.out.println(list.length-1);
        // }else{
        //     System.out.println(list.length);
        // }
        
    }
}
