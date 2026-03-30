import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] v;
	static int N, ans = 0;
	static int res[], arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		res = new int[9];
		v = new boolean[9];
		
		// 4번째는 첫 번째로 고정
		res[3] = 0;
		v[0] = true;
		
		permutation(0);
		System.out.println(ans);
	}
	
	// 순열
	private static void permutation(int idx) {
		if(idx == 3) {
			permutation(idx+1);
			return;
		}
		
		if(idx == 9) {
			start();
			return;
		}
		
		for(int i = 1; i < 9; i++) {
			if(!v[i]) {
				v[i] = true;
				res[idx] = i;
				permutation(idx + 1);
				v[i] = false;
			}
		}
	}
	
	private static void start() {
		int idx = 0;
		int score = 0;
		
		for(int i = 0; i < N; i++) {
			int out = 0;
			int[] v = new int [4];
			
			while(out < 3) {
				int hit = arr[i][res[idx]];
				if(hit == 0) {
					out++;
				} else if(hit == 1) {
					if(v[3] == 1) {
						score++;
						v[3] = 0;
					}
					v[3] = v[2];
					v[2] = v[1];
					v[1] = 1;
				} else if(hit == 2) {
					if(v[3] == 1 || v[2] == 1) {
						score += v[3] + v[2];
						v[3] = v[2] = 0;
					}
					v[3] = v[1];
					v[1] = 0;
					v[2] = 1;
				} else if(hit == 3) {
					score += v[3] + v[2] + v[1];
					v[3] = v[2] = v[1] = 0;
					v[3] = 1;
				}else if(hit == 4) {
					score += v[3] + v[2] + v[1] + 1;
					v[1] = v[2] = v[3] = 0;
				}
				idx = (idx + 1) % 9;
			}
		}
		ans = Math.max(ans, score);
	}

}