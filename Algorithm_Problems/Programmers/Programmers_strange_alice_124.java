import java.util.*;

class Solution {
    
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        int tmp = 0;
        while(n> 0){
            tmp = n % 3;
            n /= 3;
            if(tmp == 0){
                sb.append('4');
                n -= 1;
            }else{
                sb.append(tmp);
            }
        }
        answer = sb.reverse().toString();
        return answer;
        
        
    }
}