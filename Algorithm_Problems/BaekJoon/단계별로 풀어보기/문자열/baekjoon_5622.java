import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon_5622 {
    // 5622 다이얼
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int cnt = 0;
        for(int i = 0; i < input.length(); i++){
            char a = input.charAt(i);

            if(a>='A' && a<='C'){
                cnt+=3;
            }else if(a>='D' && a <= 'F'){
                cnt+=4;

            }else if(a>='G' && a <= 'I'){
                cnt+=5;
            }else if(a>='J' && a <= 'L'){
                cnt+=6;
            }else if(a>='M' && a <= 'O'){
                cnt+=7;
            }else if(a>='P' && a <= 'S'){
                cnt+=8;
            }else if(a>='T' && a <= 'V'){
                cnt+=9;
            }else if(a>='W' && a <= 'Z'){
                cnt+=10;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();       
    }
    
}
