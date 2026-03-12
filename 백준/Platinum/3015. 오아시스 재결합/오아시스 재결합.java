import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<int[]> st = new Stack<>();
		long cnt = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			int same = 1;
			if(!st.empty()) {				
				while(!st.empty() && num > st.peek()[0]) {
					cnt+=st.pop()[1];
				}
				if(!st.empty() && num == st.peek()[0]) {
					cnt += st.peek()[1];
					same = st.peek()[1] + 1;
					st.pop();
				}
				if(!st.empty() && num < st.peek()[0]) cnt++;
			}
			st.push(new int[] {num, same});
		}
		System.out.println(cnt);
	}
}
