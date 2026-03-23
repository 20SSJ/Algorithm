import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String boom = br.readLine();
		Stack<Character> st = new Stack<>();
		
		int bomb = boom.length();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			st.push(ch);
			if(st.size() >= bomb) {
				boolean bflg = true;
				for(int j = 0; j < bomb; j++) {
					if(st.get(st.size() - bomb + j) != boom.charAt(j)) {
						bflg = false;
						break;
					}
				}
				if(bflg) {
					for(int k = 0; k < bomb; k++) {
						st.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(char a : st) sb.append(a);
		
		if(st.size() == 0) System.out.println("FRULA");
		else System.out.println(sb);
	}

}
