import java.util.LinkedList;
import java.util.Queue;

public class programmers_network {
	static boolean[] check;
	static int answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		check = new boolean[n];
		//
		answer = 0;
		for(int i = 0; i < n ; i++) {
			if(check[i] == false) {
				bfs(computers,i);
				answer++;
			}
		}
		System.out.println(answer);
	}
	private static void bfs(int[][] computers, int i) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		check[i] = true;
		q.add(i);
		while(!q.isEmpty()) {
			int tmp = q.poll(); // 컴퓨터 번호
			for(int p = 0; p < computers.length; p++) {
				if(computers[tmp][p] == 1 && check[p] == false) {
					check[p] = true;
					q.add(p);
				}
			}
		}
	}

}
