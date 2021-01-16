import java.io.*;


public class baekjoon_2941 {
    // 2941 크로아티아 알파벳
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int cnt = 0;
        int len = input.length()-1;
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if( (c == 'c' || c == 'd' || c == 'l' || c =='n' || c == 's' || c == 'z') && i <= len-1){
                switch(c){
                    case 'c':
                        if(input.charAt(i+1) == '=' || input.charAt(i+1) == '-' ){
                            i++;
                        }
                        cnt++;
                        break;
                    case 'd':
                        if(input.charAt(i+1) == '-' ){
                            i++;
                        }else if(input.charAt(i+1) == 'z' && i <= len-2){
                            if(input.charAt(i+2) == '='){
                                i +=2;
                            }
                        }
                        cnt++;
                        break;
                    case 'l':
                        if(input.charAt(i+1) == 'j'){
                            i++;
                        }
                        cnt++;
                        break;
                    case 'n':
                        if(input.charAt(i+1) == 'j' ){
                            i++;
                        }
                        cnt++;
                        break;
                    case 's':
                        if(input.charAt(i+1) == '=' ){
                            i++;
                        }
                        cnt++;
                        break;
                    case 'z':
                        if(input.charAt(i+1) == '=' ){
                            i++;
                        }
                        cnt++;
                        break;
                }
            }else{
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
}
