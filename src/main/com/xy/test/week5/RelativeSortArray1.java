package main.com.xy.test.week5;

import java.util.Arrays;
import java.util.HashMap;

public class RelativeSortArray1 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] arr3 = new int[arr1.length];
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
        int[] newint = new int[arr1.length - i3];
        int i4= 0;
        for (Integer integer : map.keySet()) {
            Integer integer1 = map.get(integer);
            for (Integer i = 0; i < integer1; i++) {
                newint[i4] = integer;
                i4++;
            }


        }
        Arrays.sort(newint);
        for (int i = 0; i < newint.length; i++) {
            arr3[i3] = newint[i];
            i3++;
        }
        return arr3;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() !=t.length()) return false;
        char[] chars = t.toCharArray();
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer integer = hashMap.get(chars[i]);
            if(integer == null){
                hashMap.put(chars[i]+"",1);
            }else {
                hashMap.put(chars[i]+"",integer+1);
            }
        }
        char[] chars1 = s.toCharArray();
        HashMap<String,Integer> hashMap1 = new HashMap<>();
        for (int i = 0; i < chars1.length; i++) {
            Integer integer = hashMap1.get(chars1[i]);
            if(integer == null){
                hashMap1.put(chars1[i]+"",1);
            }else {
                hashMap1.put(chars1[i]+"",integer+1);
            }
        }
        for (String integer : hashMap.keySet()) {
            Integer integer1 = hashMap1.get(integer);
            if(integer1==null){
                return false;
            }
            Integer integer2 = hashMap.get(integer);
            System.out.println(integer+"--"+integer1 +"--"+integer2);
            if(integer2.intValue() != integer1.intValue()){
                return false;
            }
        }
        return true;
    }
}
