import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, M;
	static int ans = 0;
	static ArrayList<int []> virus;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int [][]lab = new int[N][M];
		virus = new ArrayList<>();
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				lab[r][c] = Integer.parseInt(st.nextToken());
				if(lab[r][c] == 2) virus.add(new int[] {r, c});
			}
		}
		
		backtracking(0, lab);
		System.out.println(ans);
	}
	
	private static void backtracking(int idx, int[][] lab) {
		if(idx == 3) {
			int[][] map = new int[N][M];
			for(int i = 0; i < N; i++) map[i] = lab[i].clone();
			ans = Math.max(ans, Spreadvirus(map));
			return;
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(lab[r][c] == 0) {
					lab[r][c] = 1;
					backtracking(idx + 1, lab);
					lab[r][c] = 0;
				}
			}
		}
	}
	
	private static int Spreadvirus(int[][] map) {
		Queue<int[]>q = new ArrayDeque<>();
		for(int i = 0; i < virus.size(); i++) {
			q.offer(new int[] {virus.get(i)[0], virus.get(i)[1]});
		}
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				if(isValid(nr, nc) && map[nr][nc] == 0) {
					map[nr][nc] = 2;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) count++;
			}
		}
		return count;
	}
	private static boolean isValid(int r, int c) {
		return (r >= 0 && c >= 0 && r < N && c < M);
	}

}
