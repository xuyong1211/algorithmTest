package main.com.xy.test.week4;

public class HammingWeight1 {


    // 移除末尾1 n & ( n -1 )
    public int hammingWeight(int n) {
        int m = n;
        int count = 0;
        while (m!=0){
            count ++ ;
            m = m&(m-1);
        }
        return count;
    }
}
