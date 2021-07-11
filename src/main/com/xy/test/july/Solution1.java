package main.com.xy.test.july;

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution1 {
    private HashMap<Integer,Integer> hashMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i],i );
        }

        return buildTree(preorder,0,preorder.length-1,hashMap,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder,int preStart ,int preEnd,HashMap<Integer,Integer> hashMap,int inLeft,int inRight){
        if(preStart > preEnd || inLeft > inRight){
            return null;
        }
        TreeNode rootNode = new TreeNode();
        Integer inIndex = hashMap.get(preorder[preStart]);
        rootNode.val = preorder[preStart];
        rootNode.left = buildTree(preorder,preStart+1,inIndex-inLeft+preStart,hashMap,inLeft,inIndex-1);
        rootNode.right = buildTree(preorder,inIndex-inLeft+preStart+1,preEnd,hashMap,inIndex+1,inRight);
        return rootNode;
    }
}
