class Solution {
    private int countPath(int i,int j,int[][] obstacleGrid,int[][] dp){
        if(i<0||j<0||obstacleGrid[i][j]==1)
            return 0;
        if(i==0&&j==0)
            return 1;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int up=countPath(i-1,j,obstacleGrid,dp);
        int left=countPath(i,j-1,obstacleGrid,dp);
        return dp[i][j]=up+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp=new int[obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++){
            int[] temp=new int[obstacleGrid[0].length];
            for(int j=0;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j]==1)
                    temp[j]=0;
                else if(i==0&&j==0)
                    temp[j]=1;
                else{
                    int up=0;
                    int left=0;
                    if(i>0) up=dp[j];
                    if(j>0) left=temp[j-1];
                        temp[j]=up+left;
                }
                
            }
            for(int k=0;k<dp.length;k++){
                dp[k]=temp[k];
            }
                
        }
        return dp[dp.length-1];
    }
}