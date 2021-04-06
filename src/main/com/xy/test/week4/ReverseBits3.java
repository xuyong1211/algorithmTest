package main.com.xy.test.week4;

public class
ReverseBits3 {

    public int reverseBits(int n) {

        int h = 0;
        for (int i = 0; i < 32; i++) {
            int m = n;
            int a = (m&(1<<i))>>i;
            if(i == 0){
                h = a;
            }else if(a<0){
                h = (h<<1)-a;
            }else {
                h = (h<<1)+a;
            }

        }
        return h;
    }
}
