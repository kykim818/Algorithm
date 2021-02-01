import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_2447{
    // 2447 별 찍기 - 10
    static char[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(char[] a : map){
            for(char b : a){
                Arrays.fill(a, ' ');
            }
        }
        printStar(0,0,N);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j< N; j++){
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    private static void printStar(int row,int col,int N){
            if( N == 1){
                map[row][col] = '*';
                return;
            }
            int div = N/3;
            for(int i =0; i< 3; i++){
                for(int j = 0; j < 3; j++){
                    if(i== 1 && j==1)
                        continue;
                    else
                        printStar(row + (i * div), col + (j * div), div);
                }
            }
        }

}