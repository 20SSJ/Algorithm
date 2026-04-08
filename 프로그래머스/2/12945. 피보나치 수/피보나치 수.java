class Solution {
    public int solution(int n) {
        int[] fib = new int[n + 1];
        if(n < 2){
            return n;
        }
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i <= n; i++){
            fib[i] = (fib[i - 1] + fib[i - 2]) % 1234567;
        }
        int answer = fib[n] % 1234567;
        return answer;
    }
}