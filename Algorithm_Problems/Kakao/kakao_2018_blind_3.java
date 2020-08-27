package Algorithm_Problems.Kakao;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 2020.08.26 
 * https://programmers.co.kr/learn/courses/30/lessons/17680#
 * 캐시
 */
public class kakao_2018_blind_3{

	public static void main(String[] args) {
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        //Test input
		int cacheSize = 1;
        String[] cities = {"Jeju","Pangyo","Pangyo","Pangyo"};
        
		int excuteTime = 0; 
		Queue<String> q = new LinkedList<>();
		// 
		
        // 캐시 사이즈가 0일때
		if(cacheSize == 0) {
            //모두 miss match
            //miss excutiontime * 리스트 길이 
            excuteTime = 5 * cities.length;
            //
		}else {
            //체크한 input의 개수 (검색어 개수)
            int cnt = 0;
			for(String city : cities) {
                //대소문자 구분이없으므로 전부 대문자로 바꿔주기
                city = city.toUpperCase();
                
                //현재 검색한 개수가 캐시사이즈 이상 : 캐시를 전부 채웠으면
                //분기 이유 :  
				if(cnt >= cacheSize) {
                    // 캐시에 검색한 도시가 있으면 
                    // hit으로 실행시간 +1
                    // 캐시테이블에서 검색한 애를 가장 최근이므로 제일 나중에 삭제하게 만들기

					if(q.contains(city)) {
						excuteTime++;
						String last = city;
						int size = q.size();
						for(int i = 0; i< size; i++) {
							if(q.element().equals(last)) {
								q.poll();
							}else {
								String tmp = q.poll();
								q.add(tmp);
							}
						}
						q.add(last);
					}else {
						excuteTime += 5;
						q.poll();
						q.add(city);
					}
				}else {
					if(q.contains(city)) {
						excuteTime++;
						String last = city;
						int size = q.size();
						for(int i = 0; i< size; i++) {
							if(q.element().equals(last)) {
								q.poll();
							}else {
								String tmp = q.poll();
								q.add(tmp);
							}
						}
						q.add(last);
						
					}else {
						q.add(city);
						excuteTime += 5;
						cnt++;
					}
				}
			}
		}
		System.out.println(excuteTime);
		
	}

}