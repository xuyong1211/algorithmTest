package main.com.xy.test.july;

import java.util.HashMap;

public class Solution2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return buildTree1(hashMap, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

    }

    public TreeNode buildTree1(HashMap<Integer, Integer> inHashMap, int inLeft, int inRight, int[] postOrder, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight || postLeft < 0 || inLeft < 0) {
            return null;
        }
        Integer inIndex = inHashMap.get(postOrder[postRight]);
        TreeNode node = new TreeNode();
        node.val = postOrder[postRight];
        node.left = buildTree1(inHashMap, inLeft, inIndex - 1, postOrder, postLeft, inIndex - inLeft + postLeft-1);
        node.right = buildTree1(inHashMap, inIndex + 1, inRight, postOrder, inIndex - inLeft+postLeft , postRight - 1);
        return node;
    }
}
