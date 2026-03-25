import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hm = new HashMap<>();
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String input = st.nextToken();
				hm.put(input, hm.getOrDefault(input, 0) + 1);
			}
			
			int sum = 1;
			
			for(Entry<String, Integer> es : hm.entrySet()) {
				sum *= es.getValue() + 1;
			}
			
			System.out.println(sum - 1);
		}
	}

}
