import java.io.*;
import java.util.*;

// 50 50 70 80
// 50 70 80
class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int answer = 0;
        while(left <= right){ // 처음부터 시작
            if(people[left] + people[right] <= limit){
                left++;
            }
            right--;  // 이전 값으로 이동
            answer++;
        } 
        return answer;
    }
}