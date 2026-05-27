import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int K = Integer.parseInt(st.nextToken());
       int[] arr = new int[N];
       st = new StringTokenizer(br.readLine());
       for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
       }
       int cnt = 0;
       for(int i = 0; i < N; i++){
           for(int j = i + 1; j < N; j++){
                if(i == j) continue;
                int res = 0;
               for(int k = j + 1; k < N; k++){
                    if(i == k || j == k) continue;
                    res = arr[i] + arr[j] + arr[k];
                    if(res == K) cnt++;
               }
           }
       }
       System.out.print(cnt);
    }
}