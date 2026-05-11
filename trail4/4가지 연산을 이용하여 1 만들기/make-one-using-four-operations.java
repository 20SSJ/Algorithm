import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] v = new boolean[1000001];
        
        int n = Integer.parseInt(br.readLine());
        q.offer(new int[]{n , 0});
        v[n] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int num = cur[0];
            int dist = cur[1];
            if(num == 1){
                System.out.print(dist);
                break;
            }
            if(num < 1000000 && !v[num + 1]){
               q.offer(new int[]{num + 1, dist + 1});
               v[num + 1] = true;
            }
            if(num % 2 == 0 && !v[num / 2]){
                q.offer(new int[]{num / 2, dist + 1});
                v[num / 2] = true;
            }
            if(num % 3 == 0 && !v[num / 3]){
                q.offer(new int[]{num / 3, dist + 1});
                v[num / 3] = true;
            }
            if(num > 0 && !v[num - 1]){
                q.offer(new int[]{num - 1, dist + 1});
                v[num - 1] = true;
            }
        }
    }
}