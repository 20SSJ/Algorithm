import java.io.*;
import java.util.*;

public class Main {

	static List<Integer> tree[];
	static int[] build;
	
	private static void inorder(int start, int end, int depth) {
		if(start > end) return;
		
		int mid = (start + end) / 2;
		tree[depth].add(build[mid]);
		inorder(start, mid - 1, depth + 1);
		inorder(mid + 1, end, depth + 1);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		int size = (1 << K) - 1;
		
		build = new int[size];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < size; i++) {
			build[i] = Integer.parseInt(st.nextToken());
		}
		
		tree = new ArrayList[K];
		for(int i = 0; i < K; i++) tree[i] = new ArrayList<>();
		
		inorder(0, size - 1, 0);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < K; i++) {
			for(int Node : tree[i]) sb.append(Node).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
