package main.com.xy.test.week3;

public class MaximalSquare_11 {

    /**
     * https://leetcode-cn.com/problems/maximal-square/solution/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/
     * 关注右下角为‘1’的矩阵，dp[i][j] 代表以i j坐标的点为右下角并包含这个右下角的最大正方形的边长
     * 如果 matrix[i][j] == '0' 就不用看了
     *
     * dp[i][j] 是 dp[i-1][j] dp[i][j-1] dp[i-1][j-1] 三者取最小的 然后 加一  图解分析看上面链接
      * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length <1 ||matrix[0].length < 1)return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];//避免判断 增加最左的一列和最上的一行初始值为0
        int sum = 0 ;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == '1'){
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i][j])+1;
                    sum = Math.max(dp[i+1][j+1],sum);
                }
            }
        }
        return sum*sum;
    }
}

