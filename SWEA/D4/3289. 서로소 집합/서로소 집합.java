import java.io.*;
import java.util.*;
public class Solution {

	static int N, parents[];
	
	public static void makeSets() {
		parents = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;
		return;
	}
	
	public static int check(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return 1;
		
		else return 0;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			makeSets();
			
			int M = Integer.parseInt(st.nextToken());
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int h = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken()); 
				if(h == 0) {
					union(a, b);
				} else sb.append(check(a, b));
			}
			System.out.println("#" + test + " " + sb);
		}
	}

}
