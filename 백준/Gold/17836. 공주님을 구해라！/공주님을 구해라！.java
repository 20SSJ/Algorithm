import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int r, c, sword, weight;
        
        public Node(int r, int c, int sword, int weight) {
            this.r = r;
            this.c = c;
            this.sword = sword;
            this.weight = weight;
        }
    }
    
    static int N, M, time, map[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    
    private static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0, 0));
        boolean v[][][] = new boolean[N][M][2];
        v[0][0][0] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            for(int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                int knife = cur.sword;
                int dist = cur.weight;
                
                if(cur.r == N -1 && cur.c == M - 1) {
                	return dist;
                }
                
                if(isValid(nr, nc) && !v[nr][nc][knife]) {
                    if(knife == 1) {
                        q.offer(new Node(nr, nc, knife, dist + 1));
                        v[nr][nc][knife] = true;
                    } else {
                        if(map[nr][nc] != 1) {
                            if(map[nr][nc] == 2) knife = 1;
                            q.offer(new Node(nr, nc, knife, dist + 1));
                            v[nr][nc][knife] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    private static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        time = bfs();
        
        if(time > T || time == -1) System.out.println("Fail");
        else System.out.println(time);
    }

}