import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hm = new HashMap<>();
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String item = st.nextToken();
				String input = st.nextToken();
				if(!hm.containsKey(input)) hm.put(input, 2);
				else {
					int value = hm.get(input) + 1;
					hm.put(input, value);
				}
			}
			
			int sum = 1;
			
			for(int v : hm.values()) sum *= v;
			System.out.println(sum - 1);
		}
	}

}
