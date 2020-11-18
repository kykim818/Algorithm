import java.util.Arrays;

public class Programmers_snail_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int cnt = n*(n+1)/2;
        int[] answer = new int[cnt];
        int[][] arr = new int[n][n];
        int[][] dir = {{1,0},{0,1},{-1,-1}};
        int start = 1;
        int row = 0;
        int col = 0;
        int code = 0;
        arr[row][col] = start;
        int mov_row = 0;
        int mov_col = 0;
        while(cnt > 1){
            mov_row = row + dir[code][0];
            mov_col = col + dir[code][1];
            if(mov_row >= 0 && mov_row < n && mov_col >= 0 && mov_col < n && arr[mov_row][mov_col] == 0 ){
                   arr[mov_row][mov_col] = ++start;
                   row = mov_row;
                   col = mov_col;
            }else{
                code = (code+1) % 3;
                mov_row = row + dir[code][0];
                mov_col = col + dir[code][1];
                arr[mov_row][mov_col] = ++start;
                row = mov_row;
                col = mov_col;
            }
            cnt--;
        }
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[idx++] = arr[i][j];
            }
        }
        System.out.println(Arrays.toString(answer));
	}

}
