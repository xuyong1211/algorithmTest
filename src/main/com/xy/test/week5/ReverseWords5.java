package main.com.xy.test.week5;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords5 {
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
                    stringBuilder.delete(0,stringBuilder.length());
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
