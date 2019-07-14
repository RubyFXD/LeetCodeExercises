/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int rowl=grid.length;
        if(rowl<=0){
            return 0;
        }

        int coll=grid[0].length;

        int [][] dp =new int[rowl][coll];
        dp[0][0]=grid[0][0];

        for(int i=1;i<rowl;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int j=1;j<coll;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        for(int i=1;i<rowl;i++){
            for (int j=1;j<coll;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[rowl-1][coll-1];
    }

    public static void main(String[] args) {
        MinPathSum mp=new MinPathSum();
        System.out.println(mp.minPathSum(new int[][]{{2,3,5},{1,3,6},{3,7,9}}));
    }
}
