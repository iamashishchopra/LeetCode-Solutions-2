class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int vis[][]=new int[mat.length][mat[0].length];
        int n=mat.length;
        int m=mat[0].length;
        int ans[][]=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                ans[i][j]=mat[i][j];
                if(mat[i][j]==0){
                    vis[i][j]=1;
                    q.add(new int[]{i,j,0});
                }
            }
        }
        int dcol[]={-1,0,+1,0};
        int drow[]={0,-1,0,+1};
        while(!q.isEmpty()){
            int arr[]=q.poll();
            int i=arr[0];
            int j=arr[1];
            int counter=arr[2];
            ans[i][j]=counter;
            for(int k=0;k<4;k++){
                int new_row=i+drow[k];
                int new_col=j+dcol[k];
                if(new_row>=0&&new_col>=0&&new_row<n&&new_col<m&&vis[new_row][new_col]==0&&mat[new_row][new_col]==1){
                    vis[new_row][new_col]=1;
                    ans[new_row][new_col]=counter;
                    q.add(new int[]{new_row,new_col,counter+1});
                }
            }
        }
        return ans;
    }
}