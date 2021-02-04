import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_11650 {
    // 11650 좌표 정렬하기
    static class Point implements Comparable<Point>{
        int row,col;
        public Point(int row,int col){
            this.row = row;
            this.col = col;
        }
        @Override
        public int compareTo(Point p){
            if(this.row == p.row){
                return this.col - p.col;
            }
            return this.row - p.row;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point[] arr = new Point[N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(arr[i].row).append(" ").append(arr[i].col).append("\n");
        }
        
        System.out.println(sb);


        
    }
    
}
