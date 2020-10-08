import java.util.Arrays;

public class programmers_03_balloon {
	static int[] memo;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {9,-1,3};
		int answer = 0;
		if(a.length <= 2) {
			answer = a.length;
		}else{
			memo = new int[a.length];
			if(a[0] < a[1] && a[2] < a[1]) {
				memo[2] =2;
			}else {
				memo[2] =3;
			}
			if(a.length == 3) {
				answer = memo[2];
				System.out.println(answer);
				return;
			}
			else {
				for(int i = 3; i<a.length; i++) {
				// i가기준
					if(a[i-1] > a[i])
						memo[i] = memo[i-1] -1;
					else
						memo[i] = memo[i-1] +1;
				}
			}
			answer = memo[a.length-1];
		}
		System.out.println(Arrays.toString(memo));
		System.out.println(answer);
	}

}
