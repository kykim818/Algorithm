import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1018 {
    // 1018 체스판 다시 칠하기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for(int i = 0 ; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = input.charAt(j);
            }
        }

        //
        int ans = 64;
        int cnt = 0; // 변경횟수
        char next = '\0';
        for(int i = 0 ; i <= N-8; i++){
            for(int j = 0; j<= M-8; j++){
                cnt = 0;
                // 시작이 B
                next = 'W';
                if(map[i][j] == 'W') cnt++;
                for(int p = 0; p < 8; p++){
                    for(int q = 0; q < 8 ; q++){
                        if(p == 0 && q == 0) continue;
                        
                        if(map[i+p][j+q] != next){
                            cnt++;
                        }

                        if(next == 'W') next = 'B';
                        else next = 'W';
                    }
                    if(next == 'W') next = 'B';
                    else next = 'W';
                }
                ans = Math.min(ans, cnt);

                // 시작이 W
                cnt = 0;
                next = 'B';
                if(map[i][j] == 'B') cnt++;
                for(int p = 0; p < 8; p++){
                    for(int q = 0; q < 8 ; q++){
                        if(p == 0 && q == 0) continue;
                        
                        if(map[i+p][j+q] != next){
                            cnt++;
                        }

                        if(next == 'W') next = 'B';
                        else next = 'W';
                    }
                    if(next == 'W') next = 'B';
                    else next = 'W';
                }
                ans = Math.min(ans, cnt);
            }
        }
        System.out.println(ans);
    }
}
