package main.com.xy.test.week4;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;

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
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] arr3 = new int[arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            Integer integer = map.get(arr1[i]);
            if(integer == null){
                map.put(arr1[i],1);
            }else {
                map.put(arr1[i],integer+1);
            }

        }
        int i3 = 0;
        for (int j = 0; j < arr2.length; j++) {
            Integer integer = map.get(arr2[j]);
            if(integer != null){
                for (Integer i = 0; i < integer; i++) {
                    arr3[i3] = arr2[j];
                    i3++;
                }
                map.remove(arr2[j]);
            }
        }
        int[] newint = new int[arr1.length - arr2.length];
        int i4= 0;
        for (Integer integer : map.keySet()) {
            newint[i4] = integer;
            i4++;
        }
        Arrays.sort(newint);
        for (int i = 0; i < newint.length; i++) {
            arr3[i3] = newint[i];
            i3++;
        }
        return arr3;
    }
}
