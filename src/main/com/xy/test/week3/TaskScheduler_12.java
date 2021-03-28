package main.com.xy.test.week3;

import java.util.Arrays;

public class TaskScheduler_12 {

    /**
     * 621 任务管理器
     * https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }
        Arrays.sort(counts);
        int moreCount = 1;
        for (int i = 25; i >= 1; i--) {
            if (counts[i] == counts[i - 1]) {
                moreCount++;
            } else {
                break;
            }
        }
        int a = moreCount + ((n + 1) * (counts[25] - 1));
        return Math.max(tasks.length, a);//间隔被填满，那么就可以取任务总数，总耗时也不会小于任务总数
    }

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxs = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    }

                } else if (dp[i - 1] > 0) {
                    if ((i - dp[i - 1] - 1) > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (dp[i - dp[i - 1] - 2] >= 0) dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                        maxs = Math.max(maxs, dp[i]);
                    }
                }
            }
        }
        return maxs;
    }
}
