import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class Monthly_challenge_Adding_two_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {2,1,3,4,1};
//		HashSet<Integer> s = new HashSet<>();
		TreeSet<Integer> t = new TreeSet<>();
		for(int i = 0 ; i < numbers.length-1; i++) {
			for(int j = i+1; j<numbers.length; j++) {
				t.add(numbers[i]+numbers[j]);
			}
		}
//		
		int[] answer = new int[t.size()];
		int idx = 0;
		Iterator<Integer> value = t.iterator();
		while(value.hasNext()) {
			answer[idx++] = (int) value.next();
		}
		System.out.println(Arrays.toString(answer));
	}

}
