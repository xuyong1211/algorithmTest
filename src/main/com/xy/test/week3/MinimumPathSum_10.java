package main.com.xy.test.week3;

public class MinimumPathSum_10 {
    /**
     * 很简单  起点到终点 路径数量的变形 ，起点到当前[i][j]的最小路径和 为Min(f[i-1][j],[i][j-1]) + value[i][j]
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        int[] dp = new int[grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0){
                    dp[0] = grid[i][j];
                }else if(i == 0){
                    dp[j] = dp[j-1] + grid[i][j];
                }else if(j == 0){
                    dp[j] = dp[j] + grid[i][j];
                }else{
                    dp[j] = Math.min(dp[j-1],dp[j]) +grid[i][j];
                }
            }
        }
        return dp[grid[0].length-1];
    }
}
