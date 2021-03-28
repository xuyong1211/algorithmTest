package main.com.xy.test.week3;

public class PalindromicSubstrings_13 {
    /**
     *
     *基本上是暴力求解，每种组合判断是不是回文子串，判断条件是 首尾相同，且去掉首尾也还是回文子串
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        boolean[][] counts = new boolean[s.length()][s.length()];
        int sum = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i=0;i<=j;i++){
                if(s.charAt(i) == s.charAt(j) && (j-i < 2 || counts[i+1][j-1])){
                    counts[i][j] = true;
                    sum ++;
                }
            }
        }
        return sum;

    }
}
