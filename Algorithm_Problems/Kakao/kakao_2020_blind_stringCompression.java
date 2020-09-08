import java.util.*;

public class kakao_2020_blind_StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcbabcbde";
		int len = s.length();
		int answer = Integer.MAX_VALUE;
		// 글자 길이 단위
		if(s.length() == 1)
			answer = 1;
		else {
			for(int start = 1; start <= len; start++) {
				StringBuilder complete = new StringBuilder();
				//비교기준
				StringBuilder compareStand = new StringBuilder();
				StringBuilder compareString = new StringBuilder();
				int cnt = 1; // 찾은 횟수 
				boolean check = false; // 기준이 정해지지 않았다.
				for(int i = 0 ; i < len; i++) {
					if(check == false) {
						compareStand.append(s.charAt(i));
						if(i == len-1) {
							complete.append(compareStand.toString());
							break;
						}
						if(compareStand.length() == start)
							check = true; // 조사하려는 갯수와 동일 이제 비교시작 
					}else {
						
						//비교기준이 잇다.
						compareString.append(s.charAt(i));
						if(compareString.length() == start) {
							if(compareStand.toString().equals(compareString.toString())) { // 둘이 같은지 비교
								cnt++;
								if(i == len-1) {
									complete.append(cnt).append(compareStand.toString());
									break;
								}
								compareString.setLength(0);
							}else { // 같지않다면  다시 기준단어 정하고 
								if(cnt == 1) {
									complete.append(compareStand.toString());
								}else { // 횟수가 0이 아니었다면 
									complete.append(cnt).append(compareStand.toString());
									cnt = 1;
								}
								i -= start;
								check = false; // 기준단어 초기화되었다.
								compareStand.setLength(0);
								compareString.setLength(0);
							}
						}else {
							if(i == len-1) {
								if(cnt == 1) {
									complete.append(compareStand.toString()).append(compareString.toString());
									break;
								}
								else {
									complete.append(cnt).append(compareStand.toString()).append(compareString.toString());
									break;
								}
							}
						}
					}
				}
				if(answer >= complete.length())
					answer = complete.length();
				complete.setLength(0);
			}
		}
		System.out.println(answer);
	}
}