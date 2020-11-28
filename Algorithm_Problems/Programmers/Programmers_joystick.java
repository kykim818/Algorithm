
public class Programmers_joystick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "BABAAAAB";
		int answer = 0;
//		int len = name.length();
//		int pos = 0;
//		int right = 0;
//		int left = 0;
//		
//		for(int i = 0; i < len; i++) {
//			char a = name.charAt(i);
//			if(a == 'A') continue;
//			if(pos != i) {
//				right = i - pos;
//				left =  len - i + pos;
//				if(right <= left) {
//					answer += right;
//				}else {
//					answer += left;
//				}
//				pos = i;
//			}
//			// 위치이동 좌우
//			// 현재위치에서 왼쪽으로 이동해서 가는게
//			// 오른쪽으로 가는게 
//			// 알파벳 이동 상하
//			if(a - 'A' >= 13) {
//				answer += ('Z'- a + 1);
//			}else {
//				answer += (a - 'A');
//			}
//		}
//		int answer = 0;
		int len = name.length();
		int tmp = 0;
        int turn = len - 1;
        
        for(int i = 0; i < len; i++){
            int start = name.charAt(i) - 'A';
            int end = 'Z'- name.charAt(i) + 1;
            
            if(start > end) tmp += end;
            else tmp += start;
            
            int next = i+1;
            while(next < len && name.charAt(next) == 'A') next++;
            int a = i + len - next;
            int b = len - next;
            // 이부분이 핵심
            turn = Math.min(turn,i+len-next+ Math.min(i,len-next));
        }
        
        tmp += turn;
        answer = tmp;
		System.out.println(answer);
	}

}
