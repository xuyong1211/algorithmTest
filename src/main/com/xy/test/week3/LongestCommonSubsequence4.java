package main.com.xy.test.week3;

import java.util.List;

public class LongestCommonSubsequence4 {
    public int longestCommonSubsequence(String text1, String text2) {

//可转化为二位表分析，（1）末尾相等的text1 和text2 最长公共子序列个数为二者都同时去掉末尾后 公共子序列个数加一
//                  （2）如果末尾不同，那么取删除其中一个text末尾后，公共子序列个数的较大者
//        处理字符串问题可以尝试转化为二位表的形式 寻找子问题 进行递推
//
        int m = text1.length();
        int n = text2.length();
        int[][] nums = new int[m + 1][n + 1];//长度加一，相当于初始化，而且可以从1开始循环 避免越界判断
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    nums[i][j] = nums[i - 1][j - 1] + 1;
                } else {
                    nums[i][j] = Math.max(nums[i - 1][j], nums[i][j - 1]);
                }
            }
        }
        return nums[m][n];
    }


}
