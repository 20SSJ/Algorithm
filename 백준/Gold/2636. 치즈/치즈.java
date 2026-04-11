import java.io.*;
import java.util.*;

public class Main {

	static int cnt;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1 ,1};
	static int map[][];
	static int height, width;
	static boolean v[][];
	
	public static boolean check() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(map[i][j] == 1) return true;
			}
		}
		return false;
	}
	
	public static void del() {
		Queue<int[]> q = new ArrayDeque<>();
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(map[i][j] == 1) q.offer(new int[] {i, j});
			}
		}
		
		List<int[]> ch = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			for(int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				if(isValid(nr, nc) && map[nr][nc] == -1) {
					ch.add(new int[] {curR, curC});
					break;
				}
			}
		}
		
		for(int[] i: ch) {
			int r = i[0];
			int c = i[1];
			map[r][c] = -1;
		}
		
		cnt = ch.size();
	}
	
	public static void dfs(int r, int c) { // 외부 공기 유입
		v[r][c] = true;
		map[r][c] = -1;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(isValid(nr, nc) && map[nr][nc] != 1 && !v[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}
	
	public static boolean isValid(int r, int c) {
		return r >= 0 && r < height && c >= 0 && c < width;
	}
	
	public static void print() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		map = new int[height][width];
		for(int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		v = new boolean[height][width];
		dfs(0, 0);
		while(check()) {
			cnt = 0;
			del();
			time++;
			v = new boolean[height][width];
			dfs(0, 0);
		}
		System.out.println(time);
		System.out.println(cnt);
	}

}
