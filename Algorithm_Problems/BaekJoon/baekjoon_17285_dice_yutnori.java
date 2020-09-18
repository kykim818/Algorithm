import java.util.*;

public class baekjoon_17825_dice_yutnori {
	static int[] dice = new int[11];
	static ArrayList<Integer>[] route = new ArrayList[4];
	static class player{
		int route,score,idx,cnt;
		boolean goal = false;
		boolean last_route = false;
		public player(int route, int score, int idx,boolean goal,boolean last_route,int cnt) {
			this.route = route;
			this.score = score;
			this.idx = idx;
			this.goal = goal;
			this.last_route = last_route;
			this.cnt = cnt;
		}
	}
	static int score;
	static int max;
	static int cnt;
	static player[] list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i <= 10; i++) {
			dice[i] = sc.nextInt();
		}
		for(int i = 0; i< 4; i++) {
			route[i] = new ArrayList<Integer>();
		}
		
		int[] data = {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,0};
		for(int a : data) {
			route[0].add(a);
		}
		int[] data2 = {10,13,16,19,25,30,35,40,0};
		for(int a : data2) {
			route[1].add(a);
		}
		int[] data3 = {20,22,24,25,30,35,40,0};
		for(int a : data3) {
			route[2].add(a);
		}
		int[] data4 = {30,28,27,26,25,30,35,40,0};
		for(int a : data4) {
			route[3].add(a);
		}
		score = route[0].get(dice[1]);
		
		list = new player[4];
		if(dice[1] == 5) {
			list[0] = new player(1,route[0].get(dice[1]),0,false,true,0);
		}else {
			list[0] = new player(0,route[0].get(dice[1]),dice[1],false,false,0);
		}
		list[1] = new player(0,0,0,false,false,0);
		list[2] = new player(0,0,0,false,false,0);
		list[3] = new player(0,0,0,false,false,0);
		//말이 총 4개 
		//
//		int[] ck = {0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0};
		simulate(2);
		System.out.println(max);
	}
	private static void simulate(int i) {
		// dfs로 긴다
//		if(i >= 2)
//			System.out.println(i+"번쨰 : "+ score);
		if(i >= 11) {
			if(max < score)
				max = score;
			return;
		}
		L : for(int k= 0; k < 4; k++) {
			//이동시킬말을 선택한다.
			boolean finish = list[k].goal;
			if(finish)
				continue;
			int cur_idx = list[k].idx; // 현재 말의 위치
			int num = list[k].route; // 현재 타고 있는 말판
			int kan = dice[i]; // 이동할칸
			//조건 0. 이동할칸이 도착칸이거나 넘어가는 경우!
			if(cur_idx+kan >= route[num].size()-1) {
				cnt++;
				if(cnt >= 4) {
					if(max < score)
						max = score;
				}
				list[k].goal = true;
				list[k].route = 0;
				list[k].idx = 0;
				simulate(i+1);
				// 다시 원상복귀 시키고 다음말 이동
				cnt--;
				list[k].goal = false;
				list[k].route = num;
				list[k].idx = cur_idx;
				continue L;
			}
			//조건 1. 이동하려는 자리에 다른사람이 있는지 체크
			for(int r = 0; r< 4; r++) {
				if(r == k)
					continue;
				//가려는곳의 값으로 비교
				int val1 = route[list[r].route].get(list[r].idx); // 비교하려는 대상이 있는 말판의 값
				int val2 = route[num].get(cur_idx + kan); //현재 대상이 주사위만큼 이동했을때 위치할 말판의 값
				if(val1 == val2) {
					// 가려는 곳이 같은데  
					if(num == list[r].route) //발판도 같으면 뺴막으로 못감
						continue L;
					else { // 발판이 다른데 
						if(val1 == 10 || val1 == 20 || val1 == 25 || val1 == 35 || val1 == 40)
							continue L;
						else if(val1 == 30) {
							if(num == 0) {
								if(list[r].route == 3 && list[r].idx == 0)
									continue L;
							}else if(num == 3) {
								if(cur_idx == 0 && list[r].route == 0)
									continue L;
								else {
									if(list[r].route != 0)
										continue L;
								}
							}else {
								if(list[r].route == 3 && list[r].idx != 0)
									continue L;
							}
						}
					}
				}
				//				if(num == list[r].route && (cur_idx + kan) == list[r].idx) {
//					continue L; // 겹친순간 다른애 고르면 됨
//				}
			}
			//조건 2. 이동하려는 칸이 파랑색이라서 루트가 변경되는 경우
			//단루트가 한번이라도 변경되면 그이후는 변경되는일이 없음
			if(!list[k].last_route) {
				int val = route[num].get(cur_idx + kan);
				if(val == 10) {
					score += 10;
					list[k].route = 1;
					list[k].idx = 0;
					list[k].last_route = true;
					simulate(i+1);
					score -= 10;
					list[k].route = num;
					list[k].idx = cur_idx;
					list[k].last_route = false;
					continue L;
				}else if(val == 20) {
					score += 20;
					list[k].route = 2;
					list[k].idx = 0;
					list[k].last_route = true;
					simulate(i+1);
					score -= 20;
					list[k].route = num;
					list[k].idx = cur_idx;
					list[k].last_route = false;
					continue L;
				}else if(val == 30) {
					score += 30;
					list[k].cnt++;
					list[k].route = 3;
					list[k].idx = 0;
					list[k].last_route = true;
					simulate(i+1);
					score -= 30;
					list[k].cnt--;
					list[k].route = num;
					list[k].idx = cur_idx;
					list[k].last_route = false;
					continue L;
				}
			}
			//조건3. 그냥 간다!
			list[k].idx = cur_idx + kan;
			score += route[num].get(cur_idx + kan);
			simulate(i+1);
			list[k].idx = cur_idx;
			score -= route[num].get(cur_idx + kan);
		}
	}

}
