class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] dp=new int[amount+1];
            dp[0]=1;
        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0)
                dp[j]=1;
        }
        for(int ind=1;ind<n;ind++){
            for(int amt=1;amt<=amount;amt++){
                int notTake=dp[amt];
                int take=0;
                if(coins[ind]<=amt)
                    take=dp[amt-coins[ind]];
                dp[amt]=take+notTake;
            }
        }
        return dp[amount];
    }
}