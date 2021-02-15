import java.util.*;
import java.io.*;


public class baekjoon_14889 {
    // 14889 스타트와 링크
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] ability = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < N; j++){
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] member = new boolean[N];
        int[] res = new int[N/2];
        makeTeam(0,0,N,res,member,ability);
        System.out.println(gap);    
    }
    static int gap = Integer.MAX_VALUE;
    private static void makeTeam(int res_idx,int arr_idx,int cnt,int[] res,boolean[] member,int[][] ability){
        if(res_idx == cnt/2){
            Arrays.fill(member,false);
            for(int i = 0; i < res.length; i++){
                member[res[i]] = true;
            }
            int[] resA = new int[cnt/2];
            int idx = 0;
            for(int i = 0; i < cnt; i++){
                if(member[i] == false) resA[idx++] = i;
            }
            
            int teamA = 0;
            int teamB = 0;

            for(int i = 0; i < res.length; i++){
                for(int j = 0; j < res.length; j++){
                    if(i == j) continue;
                    teamA += ability[res[i]][res[j]];
                    teamB += ability[resA[i]][resA[j]];
                }
            }
            gap = Math.min(gap, Math.abs(teamA-teamB));
            return;
        }
        if(arr_idx == cnt) return;

        res[res_idx] = arr_idx;
        makeTeam(res_idx+1,arr_idx+1,cnt, res, member, ability);
        makeTeam(res_idx, arr_idx+1, cnt, res, member, ability);
    }
}
