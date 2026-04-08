import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int t = 0; t < n; t++) {
			int p = Integer.parseInt(br.readLine());
			int mx = 0;
			String str = "";
			for(int i = 0; i < p; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int price = Integer.parseInt(st.nextToken());
				if(price > mx) {
					mx = price;
					str = st.nextToken();
				}
			}
			System.out.println(str);
		}
	}
}
