import java.util.*;

class kakao_2019_blind_openChat {
    public static void main(String[] args){
        HashMap<String,String> user = new HashMap<>();
        int cnt = 0;
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		// 끝까지 받아서 변경된 놈 까지 적용
		for(String task : record) {
			String[] cmd = task.split(" ");
			if(cmd[0].equals("Enter")) {
				user.put(cmd[1], cmd[2]);
				cnt++;
			}else if(cmd[0].equals("Change")) {
				user.put(cmd[1], cmd[2]);
			}else {
				cnt++;
			}
		}
		String[] answer = new String[cnt];
		int idx = 0; 
		// 결과 출력
		//
		//["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
		for(String task : record) {
			String[] cmd = task.split(" ");
			if(cmd[0].equals("Enter")){
//				System.out.println(user.get(cmd[1])+"님이 들어왔습니다.");
				answer[idx++] = user.get(cmd[1])+"님이 들어왔습니다.";
			}else if(cmd[0].equals("Leave")) {
//				System.out.println(user.get(cmd[1])+"님이 나갔습니다.");
				answer[idx++] = user.get(cmd[1])+"님이 나갔습니다.";
			}
        }
        System.out.println(answer);
        // return answer;
    }
}