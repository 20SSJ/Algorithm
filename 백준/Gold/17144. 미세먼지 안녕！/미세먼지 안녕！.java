import java.io.*;
import java.util.*;

public class Main {

	static class Node{
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int dr[] = {-1, 0, 1, 0}; // 상, 우, 하, 좌
	static int dr1[] = {1, 0, -1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int R, C, grid[][], map[][];
	static ArrayList<Node> dustMachine;
	
	
	private static void cleanDust() {
		
		// 공기청정기 위치
		int r1 = dustMachine.get(0).r;
		int r2 = dustMachine.get(1).r;
		
		int nxtR = dustMachine.get(0).r;
		int nxtC = dustMachine.get(0).c;
		
		int d = 0;
		while(d < 4) {
			// 현재 블록
			int curR = nxtR;
			int curC = nxtC;
			
			// 다음 블록
			nxtR += dr[d];
			nxtC += dc[d];
			
			if(grid[curR][curC] == -1) { // 현재 블록이 청정기이면
				grid[nxtR][nxtC] = 0; // 흡수
				continue;
			}
			
			if(isValid(nxtR, nxtC) && nxtR <= r1) {
				if(grid[nxtR][nxtC] == -1) {
					grid[curR][curC] = 0;
					break;
				}
				grid[curR][curC] = grid[nxtR][nxtC];
			}else { // 불가능하면
				// 취소
				nxtR -= dr[d];
				nxtC -= dc[d];
				d++;
			}
		}
		
		int nxtR2 = dustMachine.get(1).r;
		int nxtC2 = dustMachine.get(1).c;
		
		d = 0;
		while(d < 4) {
			int curR2 = nxtR2;
			int curC2 = nxtC2;
			
			nxtR2 += dr1[d];
			nxtC2 += dc[d];
			
			if(grid[curR2][curC2] == -1) {
				grid[nxtR2][nxtC2] = 0;
				continue;
			}
			
			if(isValid(nxtR2, nxtC2) && nxtR2 >= r2) {
				if(grid[nxtR2][nxtC2] == -1) {
					grid[curR2][curC2] = 0;
					break;
				}
				grid[curR2][curC2] = grid[nxtR2][nxtC2];
			} else {
				nxtR2 -= dr1[d];
				nxtC2 -= dc[d];
				d++;
			}
		}
	}
	
	// 미세먼지 확산
	private static void diffusion(int r, int c) {
		int value = grid[r][c] / 5;
		int sub = 0;
		for(int d = 0; d < 4; d++) {
			int nxtR = r + dr[d];
			int nxtC = c + dc[d];
			if(isValid(nxtR, nxtC) && grid[nxtR][nxtC] != -1) {
				map[nxtR][nxtC] += value;
				sub += value;
			}
		}
		grid[r][c] -= sub;
	}
	
	private static void moveDust(int T) {
		for(int time = 0; time < T; time++) {
			map = new int[R][C];
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(grid[i][j] > 4) {
						diffusion(i, j);
					}
				}
			}
			
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					grid[i][j] += map[i][j];
				}
			}
			
//			System.out.println("===============================");
//			for(int i = 0; i < R; i++) {
//				for(int j = 0; j < C; j++) {
//					System.out.print(grid[i][j] + " ");
//				}System.out.println();
//			}
			
			cleanDust();
		}
	}
	
	private static boolean isValid(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		grid = new int[R][C];
		dustMachine = new ArrayList<>();
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j] == - 1) {
					dustMachine.add(new Node(i, j));
				}
			}
		}
		moveDust(T);
		
		int ans = 0;
//		System.out.println("===============================");
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(grid[i][j] > 0) {
					ans += grid[i][j];
				}
//				System.out.print(grid[i][j] + " ");
			}
		}
		System.out.println(ans);
	}

}
