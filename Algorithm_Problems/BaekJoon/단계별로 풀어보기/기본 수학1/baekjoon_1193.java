import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1193 {
    // 1193 분수 찾기 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int n = 1;
        int val = 0;
        while(true){
            val = (n * (n+1) )/ 2;
            if(X <= val) break;
            n++;
        }
        
        if(n % 2 == 0){
            System.out.println( n - (val - X) + "/"+ (1 + (val - X)));
        }else{
            System.out.println( 1 + (val - X) + "/"+ (n - (val - X))) ;
        }
    }
    
}
