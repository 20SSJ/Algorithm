import java.io.*;
import java.util.*;
public class Main {

	static ArrayList<int []> virus;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, M, cnt, ans, empty;
	
	private static void combi(int idx, int start, int sel[][]) {
		if(idx == M) {
			int curEmpty = empty;
			bfs(curEmpty, sel);
			return;
		}
		
		for(int i = start; i < virus.size(); i++) {
			sel[idx] = virus.get(i);
			combi(idx + 1, i + 1, sel);
		}
	}
	
	private static void bfs(int curEmpty, int[][] sel) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean v[][] = new boolean[N][N];
		
		for(int[] a : sel) {
			q.offer(a);
			v[a[0]][a[1]] = true;
		}
		
		cnt = 0;
		while(!q.isEmpty() && curEmpty != 0) {
			int size = q.size();
			cnt++;
			
			while(size-- > 0) {
				int[] cur = q.poll();
				int curR = cur[0];
				int curC = cur[1];
				
				for(int d = 0; d < 4; d++) {
					int nr = curR + dr[d];
					int nc = curC + dc[d];
					
					if(isValid(nr, nc) && !v[nr][nc] && map[nr][nc] != 1) {
						q.offer(new int[] {nr, nc});
						v[nr][nc] = true;
						if(map[nr][nc] == 0) curEmpty--;
					}
				}
			}
			
			if(curEmpty == 0) {
				ans = Math.min(ans, cnt);
				return;
			}
		}
	}
	
	private static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		virus = new ArrayList<>();
		empty = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) virus.add(new int[] {i, j});
				if(map[i][j] == 0) empty++;
			}
		}
		
		ans = 2501;
		if(empty == 0) {
			System.out.println(0);
			return;
		}
		
		combi(0, 0, new int[M][2]);
		if(ans == 2501) System.out.println(-1);
		else System.out.println(ans);
	}
}
