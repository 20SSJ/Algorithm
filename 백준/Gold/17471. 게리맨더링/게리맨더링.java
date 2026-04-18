import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,  arr[], adj[][];
	static boolean[] v;
	static int ans = 1000; // 인구수 100 * 10
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 구역의 개수
		N = Integer.parseInt(br.readLine());

		// 선거구의 인원수 넣어놓기
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 인접행렬
		adj = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			while(num-- > 0) {
				adj[i][Integer.parseInt(st.nextToken()) - 1] = 1;
			}
		}
		
		v = new boolean [N];
		v[0] = true; // 공집합 안 만들기
		comb(1);
		
		// 값이 안 바뀌면 나눌 수 없는 경우
		if(ans == 1000) System.out.println(-1);
		else System.out.println(ans);
		br.close();
	}
	
	private static void comb(int idx) {
		if(idx == N) {
			// 두 그룹으로 나눈기
			ArrayList<Integer> RGroup = new ArrayList<>();
			ArrayList<Integer> BGroup = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				if(v[i]) RGroup.add(i);
				else BGroup.add(i);
			}
			
			// 공집합이면 리턴
			if(BGroup.isEmpty()) return;
			int Rres, Bres;
			Rres = Bres = 0;

			if(bfs(RGroup) && bfs(BGroup)) { // 2그룹 모두 연결되어있으면
				for(int i : RGroup) {
					Rres += arr[i];
				}
				for(int i : BGroup) {
					Bres += arr[i];
				}
				ans = Math.min(ans, Math.abs(Rres - Bres));
			}
			
			return;
		}
		v[idx] = true;
		comb(idx+1);
		v[idx] = false;
		comb(idx+1);
	}
	
	private static boolean bfs(ArrayList<Integer> group) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		
		int start = group.get(0);
		q.offer(start);
		visited[start] = true;
		
		int cnt = 1; // 노드 개수
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i : group) {
				if(adj[cur][i] != 1 || visited[i]) continue;
				visited[i] = true;
				q.offer(i);
				cnt++;
			}
		}
		// 방문 가능과 그룹의 크기가 값으면 가능한 것
		return cnt == group.size();
	}
}
