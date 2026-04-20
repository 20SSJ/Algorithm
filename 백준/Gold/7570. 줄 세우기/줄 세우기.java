import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int line[] = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			line[value] = i;
		}
		
		int maxLen, curLen;
		maxLen = curLen = 1;
		for(int i = 1; i < n; i++) {
			if(line[i] < line[i + 1]) {
				curLen++;
			} else curLen = 1;
			maxLen = Math.max(maxLen, curLen);
		}
		System.out.println(n - maxLen);
	}
}
