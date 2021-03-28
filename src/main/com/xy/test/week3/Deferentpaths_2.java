package main.com.xy.test.week3;

public class Deferentpaths_2 {
    /**
     * 62 不同的路径
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] steps = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0){
                    steps[i][j] = 1;
                }else {
                    steps[i][j] = steps[i][j-1] + steps[i-1][j];
                }
            }
        }
        return steps[m-1][n-1];

    }
}
