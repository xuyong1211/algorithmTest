package main.com.xy.test.week3;

public class HouseRobber_8 {


    /**
     * 和最大子序列 类似， 前 i 位的最大和 =   max(前i-1位最大和,前i-2位最大和+第i位)
     *
     * 递推关系，一直只用到 i-1  i-2 位的最大和 所以可以只定2个int做缓存 不用数组存下每个解
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int pre = 0;
        int now = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                now = nums[0];
            }else if(i == 1){
                pre = nums[0];
                now = Math.max(nums[0],nums[1]);
            }else {
                int temp = pre;
                pre = now;
                now = Math.max(temp+nums[i],pre);
            }
        }
        return now;

    }

}
