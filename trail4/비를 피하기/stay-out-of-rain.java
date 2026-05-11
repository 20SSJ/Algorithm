import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n;
    static int[][] a, b;
    static boolean[][] v;

    private static void bfs(Queue<int[]> q){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            int dist = cur[2];

            for(int d = 0; d < 4; d++){
                int nr = curR + dr[d];
                int nc = curC + dc[d];

                if(isValid(nr, nc) && a[nr][nc] != 1 && !v[nr][nc]){
                    v[nr][nc] = true;
                    if(a[nr][nc] == 2){
                        b[nr][nc] = dist + 1;
                    }
                    q.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }
    }

    private static boolean isValid(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        n = sc.nextInt();
        int h = sc.nextInt();
        int m = sc.nextInt();
        a = new int[n][n];
        b = new int[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        v = new boolean[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int value = sc.nextInt();
                a[i][j] = value;
                if(value == 2) b[i][j] = 100;
                if(value == 3){
                    q.offer(new int[]{i, j, 0});
                    v[i][j] = true;
                }
            }
        }
        bfs(q);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(b[i][j] == 100) sb.append(-1).append(" ");
                else sb.append(b[i][j]).append(" ");
            }sb.append("\n");
        }
        System.out.print(sb);
    }
}