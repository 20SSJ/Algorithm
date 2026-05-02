import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int H, W, d;
	
	public static boolean isValid(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			char map[][] = new char[H][W];
			int start[] = new int[2];
			
			for(int i = 0; i < H; i++) {
				String str = br.readLine();
				for(int j = 0; j < W; j++) {
					char value = str.charAt(j);
					if(value == '<' || value == '>' || value == '^' || value == 'v') {
						start[0] = i;
						start[1] = j;
						if(value == '^') d = 0;
						if(value == 'v') d = 1;
						if(value == '<') d = 2;
						if(value == '>') d = 3;
					}
					map[i][j] = value;
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String cmd = br.readLine();
			
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {start[0], start[1]});
			for(int i = 0; i < N; i++) {
				int[] cur = q.poll();
				int curR = cur[0];
				int curC = cur[1];
				char c = cmd.charAt(i);
				int nr, nc;
				if(c == 'S') {
					nr = curR + dr[d];
					nc = curC + dc[d];
					while(isValid(nr, nc) && map[nr][nc] != '#') {
						if(map[nr][nc] == '*') {
							map[nr][nc] ='.';
							break;
						}
						nr += dr[d];
						nc += dc[d];
					}
					q.offer(new int[] {curR, curC});
					continue;
				}
				char tank = ' ';
				if(c == 'U') {
					d = 0;
					tank = '^';
				}
				if(c == 'D') {
					d = 1;
					tank = 'v';
				}
				if(c == 'L') {
					d = 2;
					tank = '<';
				}
				if(c == 'R') {
					d = 3;
					tank = '>';
				}
				nr = curR + dr[d];
				nc = curC + dc[d];
				if(isValid(nr, nc) && map[nr][nc] == '.') {
					map[curR][curC] = '.';
					q.offer(new int[] {nr, nc});
					map[nr][nc] = tank;
				}
				else {
					q.offer(new int[] {curR, curC});
					map[curR][curC] = tank;
				}
			}
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
