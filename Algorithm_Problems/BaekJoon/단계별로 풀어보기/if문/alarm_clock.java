import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class alarm_clock {
    // 2884 알람시계
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," ");
        int Hour = Integer.parseInt(st.nextToken());
        int Min = Integer.parseInt(st.nextToken());

        if(Min >= 45){
            Min-= 45;
            
        }else{
            if(Hour > 0 ){
                Hour -= 1;
                Min = Min + 60 - 45;
            }else{
                Hour = 23;
                Min = Min + 60 - 45;
            }
        }
        System.out.println(Hour+" "+Min);
    }
    
}
