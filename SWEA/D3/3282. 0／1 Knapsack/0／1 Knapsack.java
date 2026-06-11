import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int w[] = new int[N + 1];
			int c[] = new int[N + 1];
			
			for(int i = 1; i <=  N; i++) {
				st = new StringTokenizer(br.readLine());
				w[i] = Integer.parseInt(st.nextToken());
				c[i] = Integer.parseInt(st.nextToken());
			}
			
			int dp[] = new int[K + 1];
			
			for(int i = 1; i <= N; i++) {
				for(int j = K; j >= w[i]; j--) {
					dp[j] = Math.max(dp[j], dp[j - w[i]] + c[i]);
				}
			}
			sb.append(dp[K]).append("\n");
		}
		System.out.println(sb);
	}
}
