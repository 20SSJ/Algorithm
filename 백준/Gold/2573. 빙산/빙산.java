import java.io.*;
import java.util.*;

public class Main {

	static class Node{
		int r, c;
		
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static int N, M, cnt, sea[][];
	
	private static void dfs(int r, int c, boolean[][] v) {
		v[r][c] = true;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(isValid(nr, nc) && !v[nr][nc] && sea[nr][nc] > 0) {
				dfs(nr, nc, v);
			}
		}
	}
	
	private static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(sea[i][j] != 0) q.offer(new Node(i, j));
			}
		}
		
		int tmp[][] = new int[N][M];
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int cnt = 0;
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(isValid(nr, nc)) {
					if(sea[nr][nc] == 0) cnt++;
				}
			}
			tmp[cur.r][cur.c] = cnt; 
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sea[i][j] = Math.max(0, sea[i][j] - tmp[i][j]);
			}
		}
	}
	
	private static boolean check() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(sea[i][j] != 0) return true;
			}
		}
		
		System.out.println(0);
		return false;
	}
	
	private static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sea = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int num = 0;
		boolean[][] v = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(sea[i][j] > 0 && !v[i][j]) {
					dfs(i, j, v); // 섬 개수 세기
					num++;
				}
			}
		}
		if(num > 1) {
			System.out.println(0);
			return;
		}
		cnt = 0;
		while(check()) {
			bfs(); // 얼음 녹이기
			cnt++;
			num = 0;
			v = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(sea[i][j] > 0 && !v[i][j]) {
						dfs(i, j, v); // 섬 개수 세기
						num++;
					}
				}
			}
			if(num > 1) {
				System.out.println(cnt);
				return;
			}
		}
	}
}
