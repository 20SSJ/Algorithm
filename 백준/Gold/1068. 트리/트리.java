import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] tree;
	static int count, remove;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 노드의 수
		int N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = 0;
		for(int i = 0; i < N; i++) {
			// 부모의 번호
			int value = Integer.parseInt(st.nextToken());
			
			if(value != -1) { // 부모가 있다면
				tree[value].add(i);
			} else start = i;
		}
		
		remove = Integer.parseInt(br.readLine());
		
		if(remove == start) {
			System.out.println(0);
			return;
		}
		
		count = 0; // 리프 노드 세기
		preorder(start); // 전위 순회하면서 리프 노드 탐색
		System.out.println(count);
	}

	private static void preorder(int start) {
		int child = 0;
		
		for(int nxt: tree[start]) {
			if(nxt != remove) {
				child++;
				preorder(nxt);
			}
		}
		
		if(child == 0) count++;
	}
}
