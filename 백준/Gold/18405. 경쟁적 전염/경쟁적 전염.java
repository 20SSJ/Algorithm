import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int N, S;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Node implements Comparable<Node>{
		int r, c, v, time;
		
		public Node(int r, int c, int value, int time) {
			this.r = r;
			this.c = c;
			this.v = value;
			this.time = time;
		}
		
		public int compareTo(Node o) {
			return Integer.compare(v, o.v);
		}
	}
	
	private static void bfs(ArrayList<Node> list) {
		Queue<Node> q = new ArrayDeque<>(list);
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {				
				Node cur = q.poll();
				int curR = cur.r;
				int curC = cur.c;
				int value = cur.v;
				int time = cur.time;
				
				if(time == S) return;
				for(int d = 0; d < 4; d++) {
					int nr = curR + dr[d];
					int nc = curC + dc[d];
					if(isValid(nr, nc) && map[nr][nc] == 0) {
						map[nr][nc] = value;
						q.offer(new Node (nr, nc, value, time + 1));
					}
				}
			}
		}
	}
	
	public static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		ArrayList<Node> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if(value > 0) list.add(new Node(i, j, value, 0));
			}
		}
		
		Collections.sort(list);

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		bfs(list);
		System.out.println(map[X - 1][Y - 1]);
	}
}
