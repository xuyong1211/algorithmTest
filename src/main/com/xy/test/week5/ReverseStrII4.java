package main.com.xy.test.week5;

import java.util.ArrayList;
import java.util.List;

public class ReverseStrII4 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i%(2*k) == 0){
                int size = k -1;
                if((i + k )>= chars.length){
                    size = chars.length - 1 - i;

                }
                reverse(chars,i,i+size);


            }
        }
        return  new String(chars);
    }

    public char[] reverse(char[] chars,int begin,int end){
        if(begin == end) return chars;
        int count = end - begin;
        for (int i = 0; i <= count / 2; i++) {
            char temp = chars[begin+i];
            chars[begin+i] = chars[end - i];
            chars[end - i] = temp;
        }
        return chars;
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        List<String> stringList = new ArrayList<>();
        boolean isCteating = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != ' ' ){
                if(!isCteating){
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(chars[i]);
                isCteating = true;
            }else {
                if(!stringBuilder.toString().isEmpty()){
                    stringList.add(stringBuilder.toString());
                }
                isCteating = false;
                continue;
            }
        }
        if(chars[chars.length-1]!= ' '){
            stringList.add(stringBuilder.toString());
        }
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = stringList.size() -1; i >=0 ; i--) {
            stringBuilder1.append(stringList.get(i));
            if(i != 0){
                stringBuilder1.append(" ");
            }
        }
        return stringBuilder1.toString();
    }
}
