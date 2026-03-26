import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String target = ""; // 타겟 문자열 생성
		for(int i = 1; i <= 2 * N + 1; i++) {
			if(i % 2 == 0) {
				target += "O";
			}
			else target += "I";
		}
		int size = target.length();
		Stack<Character> st = new Stack<>();
		String s = br.readLine();
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			boolean bflg = true;
			char item = s.charAt(i);
			st.push(item);
			if(st.size() >= size) {
				for(int j = 0; j < size; j++) {
					if(st.get(st.size() - size + j) != target.charAt(j)) {
						bflg = false;
						break;
					}
				}
				if(bflg) cnt++;
			}
		}
		System.out.println(cnt);
	}

}
