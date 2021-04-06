package main.com.xy.test.week4;

public class IsPowerOfTwo2 {

    public boolean isPowerOfTwo(int n) {
        if(n == 0 || n == -2147483648) return false;
        int m = n&(n-1);
        return  m == 0;
    }


}
