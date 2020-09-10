import java.util.*;

public class kakao_blind_2020_failure_rate{
			// TODO Auto-generated method stub
		    static class rate implements Comparable<rate>{
				int stage;
				double fail_rate;
				rate(int stage,double fail_rate){
					this.stage = stage;
					this.fail_rate = fail_rate;
				}
				@Override
				public int compareTo(rate o) {
					// TODO Auto-generated method stub
					if(this.fail_rate < o.fail_rate) {
						return 1;
					}else if(this.fail_rate == o.fail_rate) {
						if(this.stage > o.stage)
							return 1;
					}
					return -1;
				}
				
			}
			static int[][] info;
			public static void main(String[] args) {
				int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
				int N = 5;
		        info = new int[stages.length][N]; // 행이 사람  열이 탄별 정보
				for(int i = 0; i < stages.length; i++) {
					for(int j = 0; j < stages[i]; j++) {
						if(j == N) {
							continue;
						}
						if(j == stages[i]-1) {
							info[i][j] = -1;
						}else {
							info[i][j] = 1;
						}
					}
				}
				// 실패율 계산
				List<rate> rate = new LinkedList<>();
//				HashMap<Integer,Double> rate = new HashMap<>();
				for(int i = 0; i < N ; i++) {
					int all = 0;
					int fail = 0;
					for(int j = 0; j< stages.length; j++) {
						if(info[j][i] == -1 || info[j][i] == 1) {
							all++;
						}
						if(info[j][i] == -1) fail++;
					}
					if(all == 0) {
						rate.add(new rate((i+1),0.0));
					}else {
						rate.add(new rate((i+1),(double)fail/all));
					}
				}
				Collections.sort(rate);
//				for(int i = 0; i < rate.size();i++) {
//					System.out.println(rate.get(i).stage);
//				}
				int[] answer = new int[N];
				for(int i = 0; i< rate.size(); i++){
					answer[i] = rate.get(i).stage;
				}
		        System.out.println(answer);
	}

}