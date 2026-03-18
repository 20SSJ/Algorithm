import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point{
        int d, r, c;

        public Point(int d, int r, int c) {
            this.d = d;
            this.r = r;
            this.c = c;
        }
    }
    
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static ArrayList<Point> tom;
    static int M, N, H, tomato[][][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        tom = new ArrayList<>();
        tomato = new int[H][N][M];
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken()); 
                    if(tomato[i][j][k] == 1) {
                        tom.add(new Point (i, j, k));
                    }
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
    	Queue<Point> q = new ArrayDeque<>();
    	boolean v[][][] = new boolean[H][N][M];
    	
    	for(Point p : tom) {
    		q.offer(p);
    		v[p.d][p.r][p.c] = true;
    	}
    	
    	int count = 0;
    	while(!q.isEmpty()) {
    		int size = q.size();
    		while(size-- > 0) {
    			Point cur = q.poll();
    			for(int d = 0; d < 6; d++) {
    				int nd = cur.d + dh[d];
    				int nr = cur.r + dr[d];
    				int nc = cur.c + dc[d];
    				
    				if(isValid(nd, nr, nc) && !v[nd][nr][nc]) {
    					if(tomato[nd][nr][nc] == 0) {
    						v[nd][nr][nc] = true;
    						tomato[nd][nr][nc] = 1;
    						q.offer(new Point(nd, nr, nc));
    					}
    				}
    			}
    		}
    		count++;
    	}
    	
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(tomato[i][j][k] == 0) {
                    	return -1;
                    }
                }
            }
        }
		return count - 1;
    }

	private static boolean isValid(int d, int r, int c) {
		return d >= 0 && d < H && r >= 0 && r < N && c >= 0 && c < M && tomato[d][r][c] != -1;
	}

}