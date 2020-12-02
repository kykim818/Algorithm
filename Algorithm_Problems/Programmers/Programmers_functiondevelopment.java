import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        
        int len = progresses.length;
        int[] days= new int[len];
        for(int i = 0; i < len; i++){
            if((100-progresses[i]) % speeds[i] == 0 ){
                days[i] = (100-progresses[i]) / speeds[i];
            }else{
                days[i] = ((100-progresses[i]) / speeds[i])+1;
            }
        }
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < len ; i++){
            if(!q.isEmpty() && q.peek() < days[i]){
                list.add(q.size());
                q.clear();
            }
            q.add(days[i]);
        }
        list.add(q.size());
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}