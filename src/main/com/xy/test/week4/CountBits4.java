package main.com.xy.test.week4;

public class
CountBits4 {


    // >>1  相当于/2 ，然后加上余数  形成递推
    public int[] countBits(int num) {
        int[] nums = new int[num+1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i>>1] + (i&1);
        }
        return nums;
    }
}
