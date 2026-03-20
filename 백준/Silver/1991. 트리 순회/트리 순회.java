import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] left;
	static int[] right;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		left = new int[N];
		right = new int[N];
		
		Arrays.fill(left, -1);
		Arrays.fill(right, -1);
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);
			
			int rootIdx = root - 'A';
			if(l != '.') left[rootIdx] = l - 'A';
			if(r != '.') right[rootIdx] = r - 'A';
		}
		
		preorder(0);
		bw.write("\n");
		inorder(0);
		bw.write("\n");
		postorder(0);
		bw.write("\n");
		
		bw.flush();
		bw.close();
	}

	private static void postorder(int v) throws IOException {
		if(left[v] != -1) {
			postorder(left[v]);
		}
		if(right[v] != -1) {
			postorder(right[v]);
		}
		bw.write(v + 'A');
	}

	private static void inorder(int v) throws IOException{
		if(left[v] != -1) {
			inorder(left[v]);
		}
		bw.write(v + 'A');
		if(right[v] != -1) {
			inorder(right[v]);
		}
	}

	private static void preorder(int v) throws IOException {
		bw.write(v + 'A');
		if(left[v] != -1) {
			preorder(left[v]);
		}
		if(right[v] != -1) {
			preorder(right[v]);
		}
	}
}
