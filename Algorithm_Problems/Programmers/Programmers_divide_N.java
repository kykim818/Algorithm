import java.util.ArrayList;

public class programmers_divde_N {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 2;
		int number = 11;
		int answer = -1;
		int[] val = new int[9];
		// 개수 1~8개  8보다크면 -1
		val[0] = 1;
		val[1] = N;
		for(int i = 2; i < 9; i++) {
			val[i] = val[i-1] * 10 + N; 
		}
		// 보통 배열선언 int[] a = new int[크기];
		ArrayList<Integer>[] list = new ArrayList[9];
		for(int i = 0; i < 9 ; i++) {
			list[i] = new ArrayList<>();
			list[i].add(val[i]);
		}
		int tmp = 0;
		// 모든결과에 대해 순차적으로 구해나가야 빠트리지 않고 계산이됨 
		// 1개를 사용했을때 -> 2개를 사용햇을때 -> 3개를 사용했을때 이런식으로 
		// 모든 결과를 구해보자
		for(int i = 2; i < 9; i++) { 
			// 2번사용부터 8번사용까지 구할것
			// j번 사용 + s번 사용 리스트 이런식으로 구할것임 
			for(int j = 1; j < i; j++) { 
			// N을 J번 사용한 숫자들의 리스트
				for(int j1 = 0; j1 < list[j].size(); j1++) {
					tmp = list[j].get(j1);
					for(int s = 0; s < list[i-j].size(); s++) {
						int s1 = list[i-j].get(s);
						if(!list[i].contains(tmp+s1)) list[i].add(tmp+s1);
						if(tmp > s1 && !list[i].contains(tmp-s1)) list[i].add(tmp-s1);
						if(!list[i].contains(tmp*s1)) list[i].add(tmp*s1);
						if(s1 != 0 && !list[i].contains(tmp / s1)) list[i].add(tmp/s1);
					}
				}
			}
		}
		L1 : for(int i = 1; i< 9; i++) {
				for(int j = 0 ; j < list[i].size(); j++) {
					if(list[i].get(j) == number) {
						answer = i;
						break L1;
					}
				}
			}
		System.out.println(answer);
	}

}
// DP로 푸는 벙법도 찾아야 할듯
