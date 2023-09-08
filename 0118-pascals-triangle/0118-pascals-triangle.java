class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lis=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            lis.add(new ArrayList<Integer>());
        }
        for(int i=0;i<numRows;i++){
            for(int j=0;j<=i;j++){
                if(j==0)    lis.get(i).add(1);
                else if(j==i)    lis.get(i).add(1);
                else{
                    lis.get(i).add(lis.get(i-1).get(j)+lis.get(i-1).get(j-1));
                }
            }
        }
        return lis;
    }
}