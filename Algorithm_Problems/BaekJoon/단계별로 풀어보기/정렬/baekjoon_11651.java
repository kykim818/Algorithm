import java.io.*;
import java.util.*;

public class baekjoon_11651 {
    // 11651 좌표정렬하기 2
    static class Point implements Comparable<Point>{
        int x,y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o){
            if(this.y == o.y){
                return this.x - o.x;
            }
            return this.y - o.y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            list.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(Point p : list){
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }
        System.out.println(sb);
    }
    
}
