import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2869 {
    // 2869 달팽이는 올라가고 싶다.
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," ");
        int A = Integer.parseInt(st.nextToken()); // 하루에 올라가는 높이
        int B = Integer.parseInt(st.nextToken()); // 하루에 떨어지는 높이
        int V = Integer.parseInt(st.nextToken()); // 올라가야 하는 높이
               
        int day = 0; // 소요일수 
       
        V -= A;
        if(V <= 0) day = 0;
        else{
            day = V / (A-B);
            if((V % (A-B) != 0)) day++;
        }
        System.out.println(day+1);

        //if(V % (A-B) == 0) day =(V / (A-B)) - (A / (A-B)) + 1 ;
        //else day = (V / (A-B)) + 1;  

        


        // while(true){
        //     day++;
        //     height += A;
        //     if(height >= V) break;
        //     height -= B;
        // }
    }
    
}
