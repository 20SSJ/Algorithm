import java.io.*;
import java.util.*;

public class Main {

	static List<Integer> party[];
	static int ppl[];
	
	private static int find(int a) {
		if(ppl[a] <= 0) return a;
		return ppl[a] = find(ppl[a]);
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;
		
		if(ppl[aRoot] < ppl[bRoot]) {
			ppl[aRoot] += ppl[bRoot];
			ppl[bRoot] = aRoot;
		} else {
			ppl[bRoot] += ppl[aRoot];
			ppl[aRoot] = bRoot;
		}
		
		return;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int know = Integer.parseInt(st.nextToken());
		ppl = new int[N + 1];
		
		for(int i = 1; i <= know; i++) {
			int known = Integer.parseInt(st.nextToken());
			ppl[known] = -1;
		}
		
		party = new ArrayList[M + 1];
		for(int i = 1; i <= M; i++) {
			party[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int person = Integer.parseInt(st.nextToken());
			party[i].add(person);
			for(int j = 1; j < num; j++) {
				int nxtPerson = Integer.parseInt(st.nextToken());
				union(person, nxtPerson);
			}
		}
		
		int ans = 0;
		for(int i = 1; i <= M; i++) {
			boolean bflg = true;
			for(int p : party[i]) {
				if(ppl[find(p)] < 0) bflg = false;
			}
			if(bflg) ans++;
		}
		System.out.println(ans);
	}
}
