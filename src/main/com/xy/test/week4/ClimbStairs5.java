package main.com.xy.test.week4;

public class ClimbStairs5 {
//动态规划   斐波那契数列
    public int climbStairs(int n) {
        int[]  nums = new int[n];
        if(n <= 2){
            return n;
        }
        nums[0] = 1;
        nums[1] = 2;
        for (int i = 2; i < n; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[n-1];
    }
}
