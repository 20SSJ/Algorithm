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
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int mx = 0;
			int r = 0;
			while(r <= N - M) {
				for(int c = 0; c <= N - M; c++) {
					int value = 0;
					for(int col = c; col < c + M; col++) {						
						for(int row = r; row < r + M; row++) {
							value += arr[row][col];
						}
					}
					if(mx < value) mx = value;
				}
				r++;
			}
			sb.append(mx).append("\n");
		}
		System.out.println(sb);
	}
}
