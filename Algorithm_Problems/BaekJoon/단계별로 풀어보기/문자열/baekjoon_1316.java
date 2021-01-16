
import java.io.*;
import java.util.Arrays;

public class baekjoon_1316 {
    // 1316 그룹단어체커
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[26];
        int answer = 0;
        for(int tc = 1; tc <= T; tc++){
            String input = br.readLine();
            char before = '\0';
            Arrays.fill(check, false);
            for(int i = 0; i < input.length(); i++){
                char c = input.charAt(i);
                if(check[c-'a'] == false){
                    check[c-'a'] = true;
                    before = c;
                }else{
                    if(before != c) break;
                }



                if(i == input.length()-1){
                    answer++;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }
}
