import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static int N, M;
	
	private static int clean(int r, int c, int dir) {
		int cnt = 0;
		while(true) {
			boolean bflg = true;
			if(map[r][c] == 0) { // 1번
				map[r][c] = 2;
				cnt++;
			}
			
			for(int d = dir; d < dir + 4; d++) { // 2번
				int p = d % 4;
				int nr = r + dr[p];
				int nc = c + dc[p];
				if(isValid(nr, nc) && map[nr][nc] == 0) bflg = false;
			}
			
			if(bflg) { // 청소되지 않은 빈칸이 없음
				int p = (dir + 2) % 4; // 후진
				r += dr[p];
				c += dc[p];
				
				if(!isValid(r, c) || map[r][c] == 1) {
					return cnt;
				}
			} else { // 3번
				for(int d = dir - 1; d >= dir - 4; d--) {
					int p = (d + 4) % 4;
					int nr = r + dr[p];
					int nc = c + dc[p];
					if(isValid(nr, nc) && map[nr][nc] == 0) {
						r = nr;
						c = nc;
						dir = p;
						break;
					}
				}
			} 
		}
	}
	
	private static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}
	}
	
	private static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int startR = Integer.parseInt(st.nextToken());
		int startC = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(clean(startR, startC, dir));
	}
}
