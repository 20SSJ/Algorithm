import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int w, h;
	static char map[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			int[] start = new int[2];
			ArrayList<int[]> fire = new ArrayList<>();
			for(int r = 0; r < h; r++) {
				String cols = br.readLine();
				for(int c = 0; c < w; c++) {
					map[r][c] = cols.charAt(c);
					if(map[r][c] == '@') {
						start[0] = r;
						start[1] = c;
					}
					if(map[r][c] == '*') {
						fire.add(new int[] {r, c});
					}
				}
			} bfs(start, fire);
		}
	}
	
	private static void bfs(int[] start, ArrayList<int[]> fire) {
		Queue<int[]> fireQ = new ArrayDeque<>();
		int[][] fireT = new int[h][w];
		for(int i = 0; i < h; i++) Arrays.fill(fireT[i], w * h);
		for(int i = 0; i < fire.size(); i++) {
			int fR = fire.get(i)[0];
			int fC = fire.get(i)[1];
			fireQ.offer(new int[] {fR, fC, 0});
			fireT[fR][fC] = 0;
		}
		
		while(!fireQ.isEmpty()) {
			int[] cur = fireQ.poll();
			int curR = cur[0];
			int curC = cur[1];
			int time = cur[2];
			
			int nxTime = time + 1;
			for(int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				if(isValid(nr, nc) && fireT[nr][nc] > nxTime) {
					fireQ.offer(new int[] {nr, nc, nxTime});
					fireT[nr][nc] = nxTime;
				}
			}
		}
		
		Queue<int[]> sQ = new ArrayDeque<>();
		int[][] sT = new int[h][w];
		for(int i = 0; i < h; i++) Arrays.fill(sT[i], w * h);
		boolean Possible = true;
		sQ.offer(new int[] {start[0], start[1], 0});
		while(!sQ.isEmpty()) {
			int[] cur = sQ.poll();
			int curR = cur[0];
			int curC = cur[1];
			int time = cur[2];
			
			if((curR == 0 || curC == 0 || curR == h - 1 || curC == w - 1) && Possible) {
				System.out.println(time + 1);
				return;
			}
			int nxTime = time + 1;
			for(int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				if(isValid(nr, nc) && sT[nr][nc] > nxTime) {
					if(fireT[nr][nc] <= nxTime) continue;
					sQ.offer(new int[] {nr, nc, nxTime});
					sT[nr][nc] = nxTime;
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}
	
	private static boolean isValid(int r, int c) {
		return (r >= 0 && c >=0 && r < h && c < w && map[r][c] != '#');
	}
}
