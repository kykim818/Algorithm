import java.util.Stack;

public class programmers_01_ternary_reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 45;
		ternary(n);
	}

	private static void ternary(int n) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		while(true) {
			stack.add(n % 3);
			n /= 3;
			if(n == 0) break;
		}
		
		Stack<Integer> result = new Stack<>();
		
		while(!stack.isEmpty()) {
			result.add(stack.pop());
		}
		int answer = 0;
		int tmp = 1;
		while(!result.isEmpty()) {
			answer += (result.pop()*10);
			tmp *= 10;
		}
	}

}
