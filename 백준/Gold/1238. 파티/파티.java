import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node>{
		int to, weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(weight, o.weight);
		}
	}
	
	static int N, M, X;
	
	private static int[] dijkstra(List<Node>[] towns) {
		Queue<Node> q = new PriorityQueue<>();
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		q.offer(new Node (X, 0));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(Node nxt : towns[cur.to]) {
				if(dist[nxt.to] > dist[cur.to]+ nxt.weight) {
					dist[nxt.to]= dist[cur.to]+ nxt.weight;
					
					q.add(new Node(nxt.to, dist[nxt.to]));
				}
			}
		}
		return dist;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		List<Node>[] XH = new ArrayList [N + 1];
		List<Node>[] RXH = new ArrayList [N + 1];
		
		for(int i = 1; i <= N; i++) {
			XH[i] = new ArrayList<>();
			RXH[i] = new ArrayList<>();
		}
		
		// X에서 집으로 돌아올 수 있는 데이터
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			XH[start].add(new Node(end, T));
			RXH[end].add(new Node(start, T));
		}
		
		int[] home = dijkstra(XH);
		int[] RH = dijkstra(RXH);
		
		int answer = -1;
		for(int i = 1; i <= N; i++) {
			answer = Math.max(answer, home[i] + RH[i]);
		}
		
		System.out.println(answer);
	}

}
