import java.io.*;
import java.util.*;

public class Main {

	static List<Node> post[];
	static class Node implements Comparable<Node>{
		int nxt, weight;
		
		public Node(int nxt, int weight) {
			this.nxt = nxt;
			this.weight = weight;
		}
		
		public int compareTo(Node o) {
			return Integer.compare(weight, o.weight);
		}
	}
	
	public static int dijkstra(int start, int N) {
		int[] path = new int[N + 1];
		Arrays.fill(path, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		path[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.weight > path[cur.nxt]) continue;
            if(cur.nxt == N) return cur.weight;

			for(Node o : post[cur.nxt]) {
				int nxtPath = path[cur.nxt] + o.weight;
				if(path[o.nxt] > nxtPath) {
					path[o.nxt] = nxtPath;
					pq.offer(new Node(o.nxt, nxtPath));
				}
			}
		}
		return path[N];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		post = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			post[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			post[from].add(new Node(to, weight));
			post[to].add(new Node(from, weight));
		}
		
		System.out.println(dijkstra(1, N));
	}
}
