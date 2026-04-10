import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int N;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static PriorityQueue<Node> pq;
	
	static class Node implements Comparable<Node>{
		int r, c, v;
		
		public Node(int r, int c, int value) {
			this.r = r;
			this.c = c;
			this.v = value;
		}
		
		public int compareTo(Node o) {
			return Integer.compare(v, o.v);
		}
	}
	
	private static void bfs(int s) {
		Queue<Node> q = new ArrayDeque<>();
		
		while(!pq.isEmpty() && s-- > 0) {
			int size = pq.size();
			while(size-- > 0) {				
				Node cur = pq.poll();
				int curR = cur.r;
				int curC = cur.c;
				int value = map[curR][curC];
				for(int d = 0; d < 4; d++) {
					int nr = curR + dr[d];
					int nc = curC + dc[d];
					if(isValid(nr, nc) && map[nr][nc] == 0) {
						map[nr][nc] = value;
						q.offer(new Node (nr, nc, value));
					}
				}
			}
			while(!q.isEmpty()) {
				pq.offer(q.poll());
			}
		}
	}
	
	public static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	public static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			} System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if(value > 0) pq.offer(new Node(i, j, value));
			}
		}
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		bfs(S);
		System.out.println(map[X - 1][Y - 1]);
	}
}
