import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_11729 {
    // 11729 하노이 탑 이동 순서
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        hanoi(K,1,3,2);
        System.out.println(cnt);
        System.out.println(sb);

    }
    private static void hanoi(int N,int start,int to,int via){
        if(N == 1){ // 기저 조건
            move(start,to);
            return;
        }
        hanoi(N-1, start, via, to);
        move(start,to);
        hanoi(N-1, via, to, start);
    }
    private static void move(int start,int to){
        cnt++;
        sb.append(start).append(" ").append(to).append("\n");
    }
}
