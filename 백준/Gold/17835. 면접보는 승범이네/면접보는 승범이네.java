import java.io.*;
import java.util.*;

public class Main {

	static List<Node> city[];
	static int N;
	static long[] dist;
	static PriorityQueue<Node> pq;
	
	static class Node implements Comparable<Node>{
		int nxt;
		long weight;
		
		public Node(int nxt, long weight) {
			this.nxt = nxt;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Long.compare(weight, o.weight);
		}
	}
	
	public static void dijk() {
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.weight > dist[cur.nxt]) continue;
			
			for(Node e: city[cur.nxt]) {
				if(dist[e.nxt] > dist[cur.nxt] + e.weight) {
					dist[e.nxt] = dist[cur.nxt] + e.weight;
					pq.offer(new Node(e.nxt, dist[e.nxt]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		city = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) city[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			city[to].add(new Node(from, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		pq = new PriorityQueue<>();
		dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		for(int i = 0; i < K; i++) {
			int v = Integer.parseInt(st.nextToken());
			pq.add(new Node(v, 0));
			dist[v] = 0;
		}
		
		dijk();
		long answer = 0;
		int number = N + 1;
		for(int i = 1; i <= N; i++) {
			if(answer < dist[i]) {
				answer = dist[i];
				number = i;
			}
		}
		System.out.println(number);
		System.out.println(answer);
	}
}
