import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for(int i = 0; i < enemy.length; i++){
            int cur = enemy[i]; // 현재 적
            n -= cur;
            pq.offer(cur);
            
            if(n < 0){
                if(k > 0){
                    n += pq.poll();
                    k--;
                }
                else break;            
            }
            answer = i;
        }
        return answer + 1;
    }
}