import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1002 {
    // 1002 터렛
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc= 1; tc<= T; tc++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input," ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if(x1 == x2 && y1 == y2){
                if(r1 == r2){
                    sb.append("-1").append("\n");
                }else{
                    sb.append("0").append("\n");
                }
            }else{
                double len = getDist(x1,y1,x2,y2);
                if(len == (r1+r2)){
                    sb.append("1").append("\n");
                }else if(len < r1 + r2){
                    if(len == r1 || len == r2){
                        sb.append("1").append("\n");
                    }else if(len < Math.abs(r1-r2)){
                        sb.append("0").append("\n");
                    }else{
                        sb.append("2").append("\n");
                    }
                }else{
                    sb.append("0").append("\n");
                }
            }
        }
        System.out.println(sb);
        
    }
    private static double getDist(int x1,int y1,int x2,int y2){
        double a = Math.pow(Math.abs(x1-x2),2);
        double b = Math.pow(Math.abs(y1-y2),2);
        return Math.sqrt(a+b);
    }
    
}
