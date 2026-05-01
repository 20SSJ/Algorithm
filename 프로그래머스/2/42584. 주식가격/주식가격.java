class Solution {
    public int[] solution(int[] prices) {
        int SIZE = prices.length;
        int[] answer = new int[SIZE];
        for(int i = 0; i < SIZE; i++){
            int cnt = 0;
            for(int j = i + 1; j < SIZE; j++){
                cnt++;
                if(prices[i] > prices[j]) break;
            }answer[i] = cnt;
        }
        return answer;
    }
}