import java.io.*;
import java.util.*;

public class Main {
    
    static int N, K, ans, res, home[][];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        home = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            home[i][0] = Integer.parseInt(st.nextToken());
            home[i][1] = Integer.parseInt(st.nextToken());
        }
        
        res = 200001;
        combi(0, 0, new int[K]);
        System.out.println(res);
    }

    private static void combi(int idx, int start, int[] sel) {
        if(idx == K) {
        	int tmp = 0;
        	int distance = 0;
            for(int i = 0; i < N; i++) {
            	int mn = 200001;
                for(int j = 0; j < K; j++) {
                    int index = sel[j];
                    distance = Math.abs(home[index][0] - home[i][0]) + Math.abs(home[index][1] - home[i][1]);
                    // 집에서 대피소 거리 중 제일 작은 것을 선택
                    mn = Math.min(mn, distance);
                }
                // 가장 가까운 것 중에서 가장 거리가 긴 값
                tmp = Math.max(tmp, mn);
            }
            
            // 가장 거리가 큰 것들 중 작은 값 구하기
            res = Math.min(res, tmp);
            return;
        }
        
        for(int i = start; i < N; i++) {
            sel[idx] = i;
            combi(idx + 1, i + 1, sel);
        }
    }
}
