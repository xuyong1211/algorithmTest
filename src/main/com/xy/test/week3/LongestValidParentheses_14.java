package main.com.xy.test.week3;

public class LongestValidParentheses_14 {


    /**
     *
     * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/
     * (i - dp[i - 1] - 1)处为‘（’
     * 32 最长有效括号
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxs = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    }

                } else if (dp[i - 1] > 0) {
                    if ((i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (i - dp[i - 1] - 2 >= 0) dp[i] = dp[i]  + dp[i - dp[i - 1] - 2];

                    }
                }
            }
            maxs = Math.max(maxs, dp[i]);
        }
        return maxs;
    }
}
