import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {

	static int N, map[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int num = 1;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == 1) {
					num++;
					dfs(r, c, num);
				}
			}
		}
		int ans = 10000;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] > 1) {
					int island = map[r][c];
					boolean[][] v = new boolean [N][N];
					ans = Math.min(ans, bfs(r, c, v, island));
				}
			}
		}
		System.out.println(ans);
	}
	
	private static void dfs(int r, int c, int num) {
		map[r][c] = num;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(isValid(nr, nc) && map[nr][nc] == 1) {
				dfs(nr, nc, num);
			}
		}
	}
	
	private static int bfs(int r, int c, boolean[][] v, int island) {
		Queue<int[]> q = new ArrayDeque<>();
		v[r][c] = true;
		q.offer(new int[] {r, c, 0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			int distance = cur[2];
			
			for(int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				if(isValid(nr, nc) && !v[nr][nc] && map[nr][nc] != island) {
					if(map[nr][nc] > 0) {
						return distance;
					}
					q.offer(new int[] {nr, nc, distance + 1});
					v[nr][nc] = true;
				}
			}
			
		}
		return 10000;
	}

	private static boolean isValid(int r, int c) {
		return (r >= 0 && r < N && c >= 0 && c < N) ;
	}
}
