import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_15686_chicken_delivery {
	static int N,M,answer;
	static int[][][] map;
	static class Point{
		int row,col;
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 맵크기
		M = sc.nextInt(); // 치킨집 최대개수
		map = new int[N][N][2];
		
		ArrayList<Point> list = new ArrayList<>();
		
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < N; j++) {
				int tmp = sc.nextInt();
				map[i][j][0] = tmp;
				if(tmp > 0) {
					map[i][j][1] = -1;
					if(tmp > 1) list.add(new Point(i,j));
				}
			}
		}
		int[] arr = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			arr[i] = i;
		}
		answer = Integer.MAX_VALUE;
		for(int i = 1; i <= M ; i++) {
			int[] res = new int[i];
			combination(arr,res,0,0,list);
		}
		System.out.println(answer);
		
	}

	private static void combination(int[] arr, int[] res, int arr_idx, int res_idx, ArrayList<Point> list) {
		if(res_idx == res.length) {
			int[][] cost = new int[N][N];
			for(int[] row : cost) {
				Arrays.fill(row, Integer.MAX_VALUE);
			}
			int cost_sum = 0;
			for(int i = 0; i < res.length; i++) {
				Point tmp = list.get(res[i]);
				for(int p = 0; p < N; p++) {
					for(int q = 0; q< N; q++) {
						if(map[p][q][1] == -1 && map[p][q][0] == 1) {
							calCost(cost,tmp,p,q);
						}
					}
				}
			}
			for(int i =0; i < N; i++) {
				for(int j =0; j < N ;j++) {
					if(map[i][j][1] == -1) cost_sum += cost[i][j];
				}
			}
			answer = Math.min(cost_sum, answer);
			System.out.println(Arrays.toString(res));
			System.out.println(cost_sum);
			return;
		}
		if(arr_idx >= arr.length) return;
		
		res[res_idx] = arr[arr_idx];
		//뽑앗을떄
		combination(arr, res, arr_idx+1, res_idx+1,list);
		//안뽑앗을때
		combination(arr, res, arr_idx+1, res_idx,list);
	}

	private static void calCost(int[][] cost, Point tmp, int p, int q) {
		// TODO Auto-generated method stub
		int val = Math.abs(tmp.row - p) + Math.abs(tmp.col - q);
		cost[p][q] = Math.min(cost[p][q],val);
	}

}
