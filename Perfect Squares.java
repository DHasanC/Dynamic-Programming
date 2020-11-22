class Solution {
    public int numSquares(int n) {
        
        //for(int i = 0)
        int[] dp = new int[n + 1];
        
        Arrays.fill(dp, n + 1);
        
        dp[0] = 0;
        
        List<Integer> squares = new ArrayList<>();
        
        for(int i = 1; i * i <= n; i++){
            squares.add(i * i);
            if(n == i * i) return 1;
        }
        
        for (int j = 1; j <= n; ++j) {
            for (int i = 0; i < squares.size(); ++i) {
                if (squares.get(i) <= j) {
                    dp[j] = Math.min(dp[j], dp[j - squares.get(i)] + 1);
               }
            }
        }
        //if(dp[amount] == amount + 1) return -1;
        return dp[n];
        
        
    }
}
