package main.com.xy.test.week3;

public class MaximumSubarray_6 {
    public int maxSubArray(int[] nums) {
        /**
         * 在保包含最后一位的子序列的最大和 为 不包含最后以为但包含倒数第二位的子序列最大和+最后一位 和 最后一位  的较大者
         *
         *
         */
        int[] maxs = new int[nums.length];
        maxs[0] = nums[0];
        int max = maxs[0];//第一位就是他自己
        for (int i = 1; i < nums.length; i++) {
            maxs[i] = Math.max(maxs[i-1],0) + nums[i];
            max = Math.max(max,maxs[i]);
        }
        return max;
    }
}
