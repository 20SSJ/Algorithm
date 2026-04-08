import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    static boolean[] cols;
    static boolean[] diag;      
    static boolean[] bdiag;
    
    public int solution(int n) {
        cols = new boolean[n + 1];
        diag = new boolean[2 * n + 1];
        bdiag = new boolean[2 * n + 1];
        answer = 0;
        nQueen(1, n);
        return answer;
    }
    
    public void nQueen(int row, int n){
        if(row > n){
            answer++;   
            return;
        }
        
        for(int col = 1; col <= n; col++){
            if(cols[col] || diag[row+col] || bdiag[row - col + n]) continue;
            cols[col] = diag[row + col] = bdiag[row - col + n] = true;
            nQueen(row + 1, n);
            cols[col] = diag[row + col] = bdiag[row - col + n] = false;
        }
    }
}