import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        boolean answer = true;
        for(int i = 0; i < s.length(); i++){
           char FE = s.charAt(i);
            if(FE == '(') st.push(FE);
            else{
                if(st.isEmpty()){
                    answer = false;
                    break;
                }else{
                    st.pop();
                }
            }
        }
        if(!st.isEmpty()) answer = false;
        return answer;
    }
}