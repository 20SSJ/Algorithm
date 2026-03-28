import java.io.*;
import java.util.*;

public class Main {

	static class Node{
		int to, weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int dist, lastNode, n;
	static List<Node> tree[];
	private static void bfs(int node, int distance) {
		Queue<Node> q = new ArrayDeque<>();
		boolean v[] = new boolean[n + 1];
		
		q.offer(new Node(node, distance));
		v[node] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(dist < cur.weight) {
				dist = cur.weight;
				lastNode = cur.to;
			}
			
			for(Node e : tree[cur.to]) {
				if(v[e.to]) continue;
				v[e.to]= true;
				q.offer(new Node(e.to, e.weight + cur.weight));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n+ 1];
		for(int i = 0; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			tree[parent].add(new Node(child, weight));
			tree[child].add(new Node(parent, weight));
		}
		
		dist = 0;
		bfs(1, 0);
		dist = 0;
		bfs(lastNode, 0);
		System.out.println(dist);
	}

}
