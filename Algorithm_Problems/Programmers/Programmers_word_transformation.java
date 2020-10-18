import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author kykim818@naver.com
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 * 단어변환
 * 비효율, 수정해야함 
 */
public class programmers_word_transformation {
	static int answer;
	static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog"};
		answer = Integer.MAX_VALUE;
		Set<String> s = new HashSet<>();
		for(int i = 0; i < words.length; i++) {
			s.add(words[i]);
		}
//		1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
//		2. words에 있는 단어로만 변환할 수 있습니다.
		int cnt = 0;
		int idx = -1;
//		System.out.println(begin.substring(0,0));
//		System.out.println(begin.substring(1));
		if(s.contains(target)) {
			dfs(begin,target,cnt,s,idx);
		}else answer = 0;
		System.out.println(answer);
		
	}
	private static void dfs(String begin, String target, int cnt, Set<String> s, int idx) {
		// TODO Auto-generated method stub
		if(begin.equals(target)) {
			answer = Math.min(answer, cnt);
			return;
		}
		if(cnt >= answer) return;
		
		for(int i = 0; i <begin.length(); i++) {
			// n번쨰자리 교체
			if(i == idx) continue;
			String front = begin.substring(0,i);
			String back = begin.substring(i+1);
			for(int j = 0; j < alphabet.length; j++){
				if(begin.charAt(i) == alphabet[j]) continue;
				String result = front + alphabet[j] + back;
				if(s.contains(result)) {
					dfs(result, target, cnt+1, s,i);
				}
			}
		}
		
	}

}
