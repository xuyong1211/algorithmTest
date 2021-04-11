package main.com.xy.test.week5;

import java.util.HashMap;

public class
FirstUniqChar3 {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer integer = hashMap.get(chars[i] + 0);
            if (integer == null) {
                hashMap.put(chars[i] + 0, 1);
            } else {
                hashMap.put(chars[i] + 0, integer + 1);
            }
        }
        for (int j = 0; j < chars.length; j++) {
            Integer integer = hashMap.get(chars[j] + 0);
            if (integer.intValue() == 1) {
                return j;
            }
        }
        return -1;
    }

    public String reverseStr(String s, int k) {
        char[] temp = new char[k];
        char[] chars = s.toCharArray();
        boolean reverse = true;
        for (int i = 0; i < chars.length; i += k) {
            if (reverse) {
                for (int i1 = 0; i1 < k; i1++) {
                    char tem = chars[i+i1];
                    chars[i + i1] = chars[k -1 +i  - i1];
                    chars[k-1 +i  - i1] = tem;
                }
            }
            reverse = !reverse;
        }
        return new String(chars);
    }
}
