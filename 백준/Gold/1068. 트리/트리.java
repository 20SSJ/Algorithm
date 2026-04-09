import java.io.*;
import java.util.*;

public class Main {
    static boolean[] v;
    static int ans;
    static ArrayList<Integer> tree[];

    public static void leaf(int root){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int cur = q.poll();

            if(v[cur]) continue;
            v[cur] = true;
            boolean bflg = true;
            for(int i : tree[cur]){
                if(v[i]) continue;
                q.offer(i);
                bflg = false;
            }
            if(bflg) ans++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        tree = new ArrayList[n];
        for(int i = 0; i < n; i++){
            tree[i] = new ArrayList<>();
        }
        v = new boolean[n + 1];
        for(int i = 0; i < n; i++){
            int node = Integer.parseInt(st.nextToken());
            if(node == -1) root = i;
            else{
                tree[node].add(i);
            }
        }
        int del = Integer.parseInt(br.readLine());
        v[del] = true;
        if(root == del){
            System.out.print(0);
            return;
        }
        ans = 0;
        leaf(root);
        System.out.print(ans);
    }
}