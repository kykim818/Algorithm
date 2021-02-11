import java.util.*;
import java.io.*;

public class baekjoon_9663 {
    // 9663 N-Queen
    static int answer; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[][] check = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                nQueen(i,j,check);
            }
        }        
        System.out.println(answer);

    }
    private static void nQueen(int row,int col,boolean[][] check){
        if(row == check.length-1){
            answer++;
            return;
        }
            

    }
}
