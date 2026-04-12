import java.io.*;
import java.util.*;

public class Solution {

	static int N, M, map[][];
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	public static int kill() {
		int ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int cross, x;
				cross = x = map[i][j];
				for(int k = 1; k < M; k++) {
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d] * k;
						int nc = j + dc[d] * k;
						if(isValid(nr, nc)) {
							cross += map[nr][nc];
						}
					}
				}
				
				for(int k = 1; k < M; k++) {
					for(int d = 4; d < 8; d++) {
						int nr = i + dr[d] * k;
						int nc = j + dc[d] * k;
						if(isValid(nr, nc)) {
							x += map[nr][nc];
						}
					}
				}
				ans = Math.max(ans, Math.max(x, cross));
			}
		}
		return ans;
	}
	
	public static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("#").append(t).append(" ").append(kill()).append("\n");
		}
		System.out.println(sb);
	}
}
