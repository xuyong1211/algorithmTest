package main.com.xy.test.week3;

import java.util.List;

public class TriangleMinimumTotal_5 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.get(triangle.size()-1).size()+1];
        for (int i = triangle.size()-1; i >=0 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                A[j] = Math.min(A[j],A[j+1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
