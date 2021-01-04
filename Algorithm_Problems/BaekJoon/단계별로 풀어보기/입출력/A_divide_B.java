import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_divide_B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input," ");
		double A = Double.parseDouble(st.nextToken());
		double B = Double.parseDouble(st.nextToken());

		System.out.println(A/B);
	}

}
