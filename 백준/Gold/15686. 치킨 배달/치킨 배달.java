import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static List<Node> house, chicken;
	static int M, ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] city = new int[N][N];
		
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if(city[i][j] == 1) house.add(new Node (i, j));
				if(city[i][j] == 2) chicken.add(new Node (i, j));
			}
		}

		ans = 2500;
		selChicken(0, 0, new boolean[chicken.size()]);
		System.out.println(ans);
	}
	
	private static void selChicken(int idx, int count, boolean[] sel) {
		if(count == M) {
			ans = Math.min(ans, calcDistance(sel));
			return;
		}
		
		for(int i = idx; i < chicken.size(); i++) {
			sel[i] = true;
			selChicken(i + 1, count + 1, sel);
			sel[i] = false;
		}
	}
	
	private static int calcDistance(boolean[] sel) {
		int totalSum = 0;
		for(Node h : house) {
			int minH = 251;
			for(int i = 0; i < chicken.size(); i++) {
				if(sel[i]) {
					int dist = Math.abs(h.r - chicken.get(i).r)+ Math.abs(h.c - chicken.get(i).c);
					minH = Math.min(minH, dist);
				}
			}
			totalSum += minH;
		}
		return totalSum;
	}

}
