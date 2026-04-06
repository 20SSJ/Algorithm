import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            int dp[] = new int[13];
            int use[] = new int[13];
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= 12; i++) {
                int usage = Integer.parseInt(st.nextToken());
                use[i] = usage;
                dp[i] = dp[i - 1] + Math.min(usage * day, month); // 한달과 하루 중 저렴한 거 선택
                if(i >= 3) { // 3월부터 
                	
                    dp[i] = Math.min(dp[i], dp[i-3] + three);
                }
            }
            int ans = Math.min(dp[12], year); // 전체와 1년 중 저렴한 거 선택
            System.out.println("#" + t + " " + ans);
        }
    }
}