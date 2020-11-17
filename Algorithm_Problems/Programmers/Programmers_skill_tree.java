import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/49993

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Character> list = new ArrayList<>();
        for(int i = 0; i< skill.length(); i++){
            list.add(skill.charAt(i));
        }
        String[] filter = new String[skill_trees.length];
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i <skill_trees.length; i++){
            String tmp = skill_trees[i];
            for(int j = 0; j <  tmp.length(); j++){
                if(list.contains(tmp.charAt(j))){
                    sb.append(tmp.charAt(j));
                }
            }
            filter[i] = sb.toString();
            sb.delete(0,sb.length());
        }

        for(int i = 0; i < filter.length; i++){
            String tmp = filter[i];
            if(filter[i] == null){
                answer++;
                continue;
            }
            boolean check = true;
            for(int j = 0; j < tmp.length(); j++){
                if(skill.charAt(j) != tmp.charAt(j)) check = false;
            }
            if(check) answer++;
        }
        return answer;
    }
}