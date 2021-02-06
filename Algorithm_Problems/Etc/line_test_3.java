import java.util.*;

public class line_test_3 {
    public static void main(String[] args) {
        String[] holidays = {"01/14","01/15","01/18","01/22","01/23","01/29","02/01","02/03","02/07"};
        int k = 2;
        int[] last = {0,31,28,31,30,31,30,31,31,30,31,30,31}; // 월별 말일
        boolean[] cal = new boolean[365];
        cal[1] = true;
        cal[2] = true;
        int sat = 1;
        int sun = 2;
        while(true){
            sat += 7;
            sun += 7;
            if(sat > 364) break;
            cal[sat] = true;
            cal[sun] = true;
        }
        int month = 0;
        int day = 0;
        int idx = 0;
        for(int i = 0; i < holidays.length; i++){
            idx = 0;
            month = Integer.parseInt(holidays[i].substring(0,2));
            day = Integer.parseInt(holidays[i].substring(3));
            for(int j = 0; j < month; j++){
                idx += last[j];
            }
            idx = idx + day - 1;
            cal[idx] = true;
        }

        boolean start = false;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i < 365; i++){
            if(cal[i] == true && start == false){
                cnt++;
                start = true;
            }else if(cal[i] == false && start == true){
                start = false;
                list.add(cnt);
                cnt = 0;
            }else if(cal[i] == true && start == true){
                cnt++;
            }
        }

        for(int i = 0; i < list.size(); i++){
            if(!(answers.contains(list.get(i)))){
                answers.add(list.get(i));
            }
        }
        Collections.sort(answers,Collections.reverseOrder());
        int answer = answers.get(k-1);
        System.out.println(answer);


    }
    
    
}
