//import java.util.Arrays;
import java.util.*;


public class Programmers_stock_price {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {2,3,4,1,3};
		Stack<Integer> beginIdxs = new Stack<>();
        int i=0;
        int[] terms = new int[prices.length];

        beginIdxs.push(i);
        for (i=1; i<prices.length; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }
        List<Integer> list = new ArrayList<>();
        System.out.println(Arrays.toString(terms));
//        return answer;
	}

}
