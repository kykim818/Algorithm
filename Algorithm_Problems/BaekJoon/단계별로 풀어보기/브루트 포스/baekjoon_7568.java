import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_7568 {
    // 7568 덩치
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][3]; // 0 몸무게 1 키 2 등수
        for(int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
            people[i][2] = 1;
        }
        int weight = 0;
        int height = 0;
        int rank = 1;
        for(int i = 0; i < N; i++){
            weight = people[i][0];
            height = people[i][1];
            rank = 1;
            for(int j = 0; j < N; j++){
                if(j == i) continue;
                if(weight < people[j][0] && height < people[j][1]){
                    rank++;
                }
            }
            people[i][2] = rank;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(people[i][2]).append(" ");
        }
        System.out.println(sb);
    }
    
}
