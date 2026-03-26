import java.io.*;
import java.util.*;

public class Main {

	static int paper[][];
	static int white, blue;
	
	private static void MK(int r, int c, int size) {
		int init = paper[r][c];
		
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
				if(paper[i][j] != init) {
					int nxtSize = size / 2;
					MK(r, c, nxtSize);
					MK(r + nxtSize, c, nxtSize);
					MK(r, c + nxtSize, nxtSize);
					MK(r + nxtSize, c + nxtSize, nxtSize);
					return;
				}
			}
		}
		
		if(init == 0) white++;
		else blue++;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		MK(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
}
