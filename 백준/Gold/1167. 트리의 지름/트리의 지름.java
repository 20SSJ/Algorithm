import java.io.*;
import java.util.*;

public class Main{
	
	static class Node{
		int to, weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
	}
	
	static int dist, lastNode;
	static boolean visited[];
	static List<Node> tree[];
	private static void dfs(int node, int distance) {
		visited[node] = true;
		
		if(dist < distance) {
			dist = distance;
			lastNode = node;
		}
		
		for(Node e : tree[node]) {
			if(visited[e.to]) continue;
			dfs(e.to, distance + e.weight);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		tree = new ArrayList[V + 1];
		for(int i = 0; i <= V; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			while(value != -1) {
				int w = Integer.parseInt(st.nextToken());
				tree[node].add(new Node(value, w));
				value = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		visited = new boolean[V + 1];
		dfs(1, 0);
		dist = 0;
		visited = new boolean[V + 1];
		dfs(lastNode, 0);
		ans = Math.max(ans, dist);
		
		System.out.println(ans);
	}
}