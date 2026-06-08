import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int v = 0;
			int dist = 0;
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				if(c == 0) {
					dist += v;
				}else {
					int a = Integer.parseInt(st.nextToken());
					if(c == 1) {						
						v += a;
					} else {
						if(v - a < 0) v = 0;
						else v -= a;
					}
					dist += v;
				}
			}
			sb.append("#" + tc + " " + dist + "\n");
		}
		System.out.println(sb);
	}
}
