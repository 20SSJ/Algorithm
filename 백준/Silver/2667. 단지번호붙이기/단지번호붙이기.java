import java.io.*;
import java.util.*;

public class Main {

	static int[][] apt;
	static int N, cnt;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean v[][];
	
	static void attachAndCnt(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		v[r][c] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				if(isValid(nr, nc) && apt[nr][nc] == 1 && !v[nr][nc]) {
					q.offer(new int[] {nr, nc});
					v[nr][nc] = true;
					cnt++;
				}
			}
		}
	}
	
	public static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		apt = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				apt[i][j] = str.charAt(j) - '0';
			}
		}
		
		v = new boolean[N][N];
		int num = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(apt[i][j] > 0 && !v[i][j]) {
					cnt = 1;
					attachAndCnt(i, j);
					arr.add(cnt);
					num++;
				}
			}
		}
		v = new boolean[N][N];
		
		Collections.sort(arr);
		
		System.out.println(num);
		for(int  i = 0; i < num; i++) {
			System.out.println(arr.get(i));
		}
	}
}
