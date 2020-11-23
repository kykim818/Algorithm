
public class Programmers_normal_rectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w = 8;
		int h = 12;
		long answer = 0;
		int cnt = gcd(w,h);
		answer = (w*h) - (cnt * (w+h-1)); 
		System.out.println(answer);
	}

	private static int gcd(int w, int h) {
		// TODO Auto-generated method stub
		int val1,val2;
		val1 = w;
		val2 = h;
		if(h > w) {
			val1 = h;
			val2 = w;
		}
		int r = 1;
		while(r > 0) {
			r = val1 % val2;
			val1= val2;
			val2= r;
		}
		return val1;
	}

}
