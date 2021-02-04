import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class baekjoon_2667 {
    // 2667 단지번호붙이기
    static int[] dr = { 0 , 0, -1, 1};
    static int[] dc = { -1, 1, 0 , 0};
    static class Point{
        int row,col;
        public Point(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        boolean[][] check = new boolean[N][N];
        
        String input = null;
        for(int i = 0; i < N; i++){
            input = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
       
        int idx = 1;
        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && check[i][j] == false){
                    cnt = bfs(i,j,map,check,idx);
                    idx++;
                    list.add(cnt);
                }
            }
        }
        
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(idx-1).append("\n");
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
    private static int bfs(int row,int col,int[][] map,boolean[][] check,int idx){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row,col));
        map[row][col] = idx;
        check[row][col] = true;
        int cnt = 1;
        while(!q.isEmpty()){
            Point tmp = q.poll();
            for(int k = 0; k < 4; k++){
                int mov_row = tmp.row + dr[k];
                int mov_col = tmp.col + dc[k];
                if(mov_row >= 0 && mov_row < map.length && mov_col >= 0 && mov_col < map.length){
                    if(map[mov_row][mov_col] != 0 && check[mov_row][mov_col] == false){
                        q.add(new Point(mov_row,mov_col));
                        check[mov_row][mov_col] = true;
                        map[mov_row][mov_col] = idx;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }    
}
