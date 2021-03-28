package main.com.xy.test.week3;

public class FibonacciLoop_1 {

    public int fibonacci(int n) {
        if (n <= 1) return n;
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;

        //可自下而上 循环递推
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }

    public int recursion(int n,int[] array) {
        if(array[n] == 0){
            array[n]  = (n <= 1) ? n : recursion(n - 1,array) + recursion(n - 2,array);
        }
        return array[n] ;
    }
}
