import java.util.*;

public class line_test_2 {

    static HashMap<String,Integer> r = new HashMap<String, Integer>();
    static int[] line;
    public static void main(String[] args) {
        int n = 2;
        String[] recipes = {"A 3","B 2"};
        String[] orders = {"A 1","A 2","B 3","B 4"};
        for(int i = 0; i< recipes.length; i++){
            String[] menu = recipes[i].split(" ");
            r.put(menu[0], Integer.parseInt(menu[1]));
        }
        

        int answer = 0;
        line = new int[n];
        int fin = 0;
        for(int i = 0; i < orders.length; i++){
            fin = makeOrder(orders[i]);
            if(i == orders.length -1){
                answer = fin;
            }
        }
        System.out.println(answer);

    }
    private static int makeOrder(String order){
        String[] d = order.split(" ");
        int useTime = r.get(d[0]);
        int idx = 0;
        int cur = Integer.parseInt(d[1]);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < line.length; i++){
            if(line[i] == 0){
                idx = i;
                break;
            }
            if(min > line[i]){
                min = line[i];
                idx = i;
            }
        }

        if(cur <= line[idx]){
            line[idx] += useTime;
        }else{
            line[idx] = cur + useTime;
        }
        return line[idx];
    }
    
}
