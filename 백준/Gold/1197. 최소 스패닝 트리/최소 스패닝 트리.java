import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node>{
		int start, end, weight;
		
		public Node(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node e) {
			return Integer.compare(weight, e.weight);
		}
	}
	
	static Node[] edgeList;
	static int[] nodes;
	
	private static void makeSet(int V) {
		nodes = new int[V + 1];
		for(int i = 1; i <= V; i++) {
			nodes[i] = -1;
		}
	}
	
	private static int findSet(int o) {
		if(nodes[o] < 0) return o;
		return nodes[o] = findSet(nodes[o]);
	}
	
	private static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		if(nodes[aRoot] < nodes[bRoot]) {
			nodes[aRoot] += nodes[bRoot];
			nodes[bRoot] = aRoot;
		} else {
			nodes[bRoot] += nodes[aRoot];
			nodes[aRoot] = bRoot;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		edgeList = new Node[E];
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edgeList[i] = new Node(s, e, w);
		}
		
		Arrays.sort(edgeList);
		
		makeSet(V);
		
		int count = 0;
		int ans = 0;
		for(Node edges: edgeList) {
			if(unionSet(edges.start, edges.end)) {
				ans += edges.weight;
				if(++count == V - 1) break;
			}
		}
		System.out.println(ans);
	}
}
