package main.com.xy.test.week5;

import java.util.HashMap;

public class
IsAnagram2 {
    public boolean isAnagram(String s, String t) {
        if(s.length() !=t.length()) return false;
        char[] chars = t.toCharArray();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer integer = hashMap.get(chars[i]+0);
            if(integer == null){
                hashMap.put(chars[i]+0,1);
            }else {
                hashMap.put(chars[i]+0,integer+1);
            }
        }
        char[] chars1 = s.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            Integer integer = hashMap.get(chars1[i]+0);

            if(integer == null || integer <= 0){
                return false;
            }else {
                hashMap.put(chars1[i]+0,integer-1);
                if(integer - 1 == 0){
                    hashMap.remove(chars1[i]+0);
                }
            }
        }
        return hashMap.isEmpty();

    }
}
