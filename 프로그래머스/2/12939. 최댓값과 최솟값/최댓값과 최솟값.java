import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) throws IOException{
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
      
        int size = st.countTokens();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ").append(arr[size - 1]);
        answer += sb;
        return answer;
    }
}