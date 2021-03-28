package main.com.xy.test.week3;

public class DeferentAPathII_3 {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] steps = new int[n+1];  // 双重循环 steps的填充是从上至下 从左至右的， 所有可以换成一维数组可以减少内存空间
        // （计算当前行 只会用到当前小于当前指针的位置 ，和上一行等于当前指针的位置），
        // 定义n+1长度 并从1开始循环 相当于给第一行上方再加一行为0的行 避免指针越界  减少判断
        //
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if(obstacleGrid[i][j-1] == 1){
                    steps[j] = 0;
                }else if(i == 0&&j == 1){
                    steps[j] = 1;
                }else{
                    steps[j] = steps[j] + steps[j-1];
                }
            }
        }
        return steps[n];
    }
}
