import java.io.*;

public class baekjoon_9663 {
    // 9663 N-Queen
    static int answer;
    static int N; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        boolean[][] check = new boolean[N][N];
        nQueen(0,check);
        System.out.println(answer);

    }
    private static void nQueen(int row,boolean[][] check){
        if(row == check.length){
            answer++;
            return;
        }
        int mov_row = 0;
        int mov_col = 0;
        for(int col = 0; col < N; col++){
            mov_row = row;
            mov_col = col;
            if(isOk(mov_row,mov_col,check)){
               check[mov_row][mov_col] = true;
               nQueen(row+1, check); 
               check[mov_row][mov_col] = false;
            }
        }
    }

    private static boolean isOk(int row,int col,boolean[][] check){
        int mov_row = row-1;
        int mov_col = col-1;
        while(mov_row >= 0 && mov_col >= 0){
            if(check[mov_row][mov_col] == true){
                return false;
            }
            mov_row--;
            mov_col--;
        }

        mov_row = row-1;
        mov_col = col;
        while(mov_row >= 0){
            if(check[mov_row][mov_col] == true){
                return false;
            }
            mov_row--;
        }

        mov_row = row-1;
        mov_col = col+1;
        while(mov_row >= 0 && mov_col < N){
            if(check[mov_row][mov_col] == true){
                return false;
            }
            mov_row--;
            mov_col++;
        }
        return true;
    }
}
