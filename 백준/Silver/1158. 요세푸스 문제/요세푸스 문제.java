import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new ArrayDeque<>();
		Queue<Integer> result = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) q.add(i);
		while(q.size() > 1) {
			for(int i = 1; i < K; i++) {
				q.offer(q.poll());
			}
			result.add(q.poll());
		}
		result.offer(q.poll());
		StringBuilder sb = new StringBuilder();
		while(result.size() > 1) {
			sb.append(result.poll()).append(", ");
		}
		sb.append(result.poll());
		System.out.println("<" + sb + ">");
	}
}
