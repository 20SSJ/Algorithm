import java.io.*;
import java.util.*;

public class Main {
	
	static int grid[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, 1, -1};
	static int N, M;
	static boolean v[][];
	static ArrayList<Node> ch;
	static class Node{
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}	
	}

	private static void dfs(int r, int c) {
		v[r][c] = true;
		grid[r][c] = -1;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(isValid(nr, nc) && !v[nr][nc] && grid[nr][nc] == 0) {
				dfs(nr, nc);
			}
		}
	}
	
	private static void bfs(int r, int c) {
		Queue<Node> q = new ArrayDeque<>();
		boolean v[][] = new boolean[N][M];
		
		q.add(new Node(r, c));
		v[r][c] = true;
		grid[r][c] = -1;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if(isValid(nr, nc) && grid[nr][nc] != 1 && !v[nr][nc]) {
					q.offer(new Node(nr, nc));
					v[nr][nc] = true;
					grid[nr][nc] = -1;
				}
			}
			
		}
	}
	
	private static boolean check() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(grid[i][j] != -1) return false;
			}
		}
		return true;
	}
	
	private static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(grid[i][j] == 1) q.add(new Node(i, j));
			}
		}
		
		int[][] tmp = new int[N][M];
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int cnt = 0;
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if(isValid(nr, nc) && grid[nr][nc] == -1) cnt++;
			}
			
			if(cnt >= 2) {
				tmp[cur.r][cur.c] = -2; 
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				grid[i][j] += tmp[i][j];
			}
		}
	}
	
	private static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		grid = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		v = new boolean[N][M];
		bfs(0, 0); // 외부 공기 표시
		while(!check()) {
			bfs(); // 치즈 녹이기
			ans++;
			bfs(0, 0); // 외부 공기 유입
		}
		System.out.println(ans);
	}
}
