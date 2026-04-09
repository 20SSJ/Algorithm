import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] t = new int[N + 1];
		int[] v = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N + 2]; // 4 
		for(int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i], dp[i-1]);
			if(i + t[i] <= N + 1) {
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + v[i]);
			} 
		}
		
		int ans = Math.max(dp[N], dp[N + 1]);
		System.out.println(ans);
	}
}
