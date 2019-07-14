/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as1and0respectively in the grid.
 * For example, There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is2.
 * Note: m and n will be at most 100.
 */
public class UniquePathsWithObstacles {
    /**
     * 动态规划
     * dp[i][j]用来保存可到点(i)(j)的支路
     * obstacleGrid[i][j]==1即为路障，dp[i][j]=0, 没有路能走过这个点
     * obstacleGrid[i][j]==0即无路障，dp[i][j]=dp[i-1][j]+dp[i][j-1], 当前点只能从左边点或上面点到达，所以可走支路为左上相加的和
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row=obstacleGrid.length;
        if(row==0 || obstacleGrid[0][0]==1){
            return 0;
        }
        int col=obstacleGrid[0].length;
        int[][] dp=new int[row][col];
        dp[0][0]=1;
        for(int i=1;i<row;i++){
            if(obstacleGrid[i][0]!=1){
                dp[i][0]=dp[i-1][0];
            }else{
                dp[i][0]=0;
            }
        }
        for(int j=1;j<col;j++){
            if(obstacleGrid[0][j]!=1){
                dp[0][j]=dp[0][j-1];
            }else{
                dp[0][j]=0;
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(obstacleGrid[i][j]!=1){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles u=new UniquePathsWithObstacles();
        System.out.println(u.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
