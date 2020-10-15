import java.util.Stack;

public class Monthly_challenge_ternary_reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 45;
		int answer = 0;
		answer = ternary(n);
		System.out.println(answer);
	}

	private static int ternary(int n) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		while(true) {
			stack.add(n % 3);
			n /= 3;
			if(n == 0) break;
		}
		int answer = 0;
		int tmp = 1;
		while(!stack.isEmpty()) {
			answer += (stack.pop()*tmp);
			tmp *= 3;
		}
		return answer;
	}

}
