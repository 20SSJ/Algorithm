import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[n + 2];
		int t[] = new int[n + 1];
		int v[] = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = n; i >= 1; i--) {
			if(i + t[i] <= n + 1) {
				dp[i] = Math.max(dp[i + t[i]] + v[i], dp[i + 1]);
			} else {
				dp[i] = dp[i + 1];
			}
		}
		System.out.println(dp[1]);
	}
}
