import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, D, E, h[];
    static List<Point> path[];
    static class Point implements Comparable<Point>{

        int to;
        long weight;
        
        public Point(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return Long.compare(weight, o.weight);
        }
    }
    
    private static long[] dijkstra(int value) {
        Queue<Point> q = new PriorityQueue<>();
        q.offer(new Point(value, 0));
        long[] height = new long[N + 1]; // 높이를 가는데 가는 거리를 저장
        Arrays.fill(height, Long.MAX_VALUE);
        height[value] = 0; 
        while(!q.isEmpty()) {
            Point cur = q.poll();
            
            if(cur.weight > height[cur.to]) continue;
            for(Point next : path[cur.to]) {
            	if(h[next.to] <= h[cur.to]) continue;
            	if(height[next.to] > height[cur.to] + next.weight) {
            		height[next.to] = height[cur.to]+ next.weight;
            		q.offer(new Point(next.to, height[next.to]));
            	}
            }
        }
		return height;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        h = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
        
        path = new ArrayList [N + 1];
        for(int i = 1; i <= N; i++) {
            path[i] = new ArrayList<>();
        }
        
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            path[a].add(new Point(b, n));
            path[b].add(new Point(a, n));
        }
        
        long[] Up = dijkstra(1);
        long[] Down = dijkstra(N);
        
        long answer = Long.MIN_VALUE;
        for(int i = 2; i < N; i++) {
        	if(Up[i] == Long.MAX_VALUE || Down[i] == Long.MAX_VALUE) continue;
        	answer = Math.max(answer, (long)h[i] * E - (Up[i] + Down[i]) * D);
        }
        if(answer == Long.MIN_VALUE) System.out.println("Impossible");
        else System.out.println(answer);
    }

}