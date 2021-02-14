import java.util.*;
import java.io.*;

public class baekjoon_2580 {
    // 2580 스도쿠
    static int[][] map;
    static boolean finish;
    static class Point{
        int row,col;
        Point(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    static ArrayList<Point> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < 9; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    list.add(new Point(i,j));
                }
            }
        }
        int cnt = list.size();
        // 리스트로 빈곳좌표를 받아서 넘기기 
        // 행기준으로 
        sudoku(0,cnt);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void sudoku(int idx,int cnt){
        if(idx == cnt){
            finish = true;
            return;
        } 
        boolean[] check = new boolean[10];
            
        Point tmp = list.get(idx);
        Arrays.fill(check, false);
        // 행체크 
        for(int i = 0; i < 9; i++){
            check[map[tmp.row][i]] = true;
        }
        // 열체크
        for(int i = 0; i < 9; i++){
            check[map[i][tmp.col]] = true;
        }
        // 칸체크
        int startRow = tmp.row / 3;
        int startCol = tmp.col / 3;
        startRow *= 3;
        startCol *= 3;
        for(int i = startRow; i < startRow+3; i++){
            for(int j = startCol; j < startCol+3; j++){
                check[map[i][j]] = true;
            }
        }

        // 
        

        for(int i = 1; i <= 9; i++){
            if(check[i] == false){
                map[tmp.row][tmp.col] = i;
                sudoku(idx+1, cnt);
                if(finish) return;
                map[tmp.row][tmp.col] = 0;
            }
        }
    }
}
