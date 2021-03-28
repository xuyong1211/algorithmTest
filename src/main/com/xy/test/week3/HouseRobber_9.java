package main.com.xy.test.week3;

public class HouseRobber_9 {

    /**
     *  213 打家劫舍II
     *
     *  可以看成 两个非环形的打家劫舍I来看，去点首位 和去掉末尾的解的 较大者
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int pre = 0;
        int now = 0;
        int now1 = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0) {
                now = nums[0];
            } else if (i == 1) {
                pre = nums[0];
                now = Math.max(nums[1], nums[0]);
            } else {
                int temp = pre;
                pre = now;
                now = Math.max(temp + nums[i], pre);
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                now1 = nums[1];
            } else if (i == 2) {
                pre = nums[1];
                now1 = Math.max(nums[2], nums[1]);
            } else {
                int temp = pre;
                pre = now1;
                now1 = Math.max(temp + nums[i], pre);
            }
        }
        return Math.max(now, now1);
    }
}
