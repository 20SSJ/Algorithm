import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i-1]) q.offer(arr[i]);
        }
        int[] answer = new int[q.size()];
        int i = 0;
        while(!q.isEmpty()){
            answer[i++] = q.poll();
        }
        return answer;
    }
}