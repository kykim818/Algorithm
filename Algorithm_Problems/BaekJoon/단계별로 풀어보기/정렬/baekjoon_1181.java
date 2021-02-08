import java.util.*;
import java.io.*;


public class baekjoon_1181 {
    // 1181 단어 정렬
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Set<String> list = new HashSet<>();
        for(int i = 0 ; i < N; i++){
            list.add(br.readLine());
        }
        List<String> list1 = new ArrayList<String>(list);
        Collections.sort(list1,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() == s2.length()){
                    // 길이가 같을때 사전식
                    return s1.compareTo(s2);
                }
                return s1.length() - s2.length();
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list1.size(); i++){
            sb.append(list1.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
