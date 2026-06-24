import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++){
            int value = priorities[i];
            pq.offer(value);
            q.offer(new int[]{value, i});
        }
        int answer = 1;
        while (!pq.isEmpty()){
            int v = pq.poll();
            int[] ans = q.poll();
            if(ans[0] != v){
                pq.offer(v);
                q.offer(ans);
            } else {
                if(ans[1] == location) return answer;
                answer++;
            }
        }
        return answer;
    }
}