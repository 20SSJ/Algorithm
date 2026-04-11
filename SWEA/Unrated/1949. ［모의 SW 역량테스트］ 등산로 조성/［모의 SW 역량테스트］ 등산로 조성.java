import java.io.*;
import java.util.*;

public class Solution {
	static int map[][];
	static int N, K, ans;
	static boolean v[][];
	
	static class Node{
		int r, c, length, work, curValue;
		
		public Node(int r, int c, int length, int work, int curValue) {
			this.r = r;
			this.c = c;
			this.length = length;
			this.work = work;
			this.curValue = curValue;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	private static void dfs(int r, int c, int w, int curV, int length) {
		ans = Math.max(ans, length);
		v[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(isValid(nr, nc) && !v[nr][nc]) {
				if(map[nr][nc] < curV) {
					dfs(nr, nc, w, map[nr][nc], length + 1);
				} else {
					if(w == 0) {
						int sub = map[nr][nc] - curV;
						if(sub < K) {
							dfs(nr, nc, 1, map[r][c] - 1, length + 1);
						}
					}
				}
			}
		}
		v[r][c] = false;
	}
	
	public static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int mx = 0;
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					int value = Integer.parseInt(st.nextToken());
					map[i][j] = value;
					if(mx < value) mx = value;
				}
			}
			
			ans = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == mx) {
						v = new boolean[N][N];
						dfs(i, j, 0, mx, 1);
					}
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
