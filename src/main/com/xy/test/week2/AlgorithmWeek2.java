package main.com.xy.test.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AlgorithmWeek2 {


    /**
     * 层序遍历  bfs
     */

    public List<List<Integer>> levelOrder(AlgorithmWeek1.TreeNode root) {
        if (root == null) return new ArrayList<>();
        LinkedList<AlgorithmWeek1.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> returns = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                AlgorithmWeek1.TreeNode pop = queue.pop();
                list.add(pop.val);

                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
            }
            returns.add(list);
        }
        return returns;
    }

    /**
     * 200 岛屿的数量
     */
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ++count;
                    dfs(i, j, n, m, grid);
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, int n, int m, char[][] grid) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i - 1, j, n, m, grid);
        dfs(i + 1, j, n, m, grid);
        dfs(i, j - 1, n, m, grid);
        dfs(i, j + 1, n, m, grid);
    }

    /**
     * 226 翻转二叉树
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            TreeNode newNode = new TreeNode();
            dfs(root, newNode);
            return newNode;
        }

        public void dfs(TreeNode root, TreeNode newNode) {
            if (root == null) return;
            newNode.val = root.val;
            if (root.left != null) {
                newNode.right = new TreeNode();
                dfs(root.left, newNode.right);

                if (root.right != null) {
                    newNode.left = new TreeNode();
                    dfs(root.right, newNode.left);
                }

            }
        }

        /**
         * 验证二叉树
         */

        TreeNode pre = null;

        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            if (!isValidBST(root.left)) return false;

            if (pre != null && pre.val >= root.val) {
                return false;
            }
            pre = root;
            return isValidBST(root.right);

        }


        /**
         * 297 二叉树的序列化 与反序列化
         */

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            String rs = "";
            rs = dfsSerialize(root, rs);
            System.out.print(rs);
            return rs;
        }

        public String dfsSerialize(TreeNode root, String rs) {
            if (root == null) {
                rs = rs + "None,";
                return rs;
            }
            rs = rs + String.valueOf(root.val) + ",";
            rs = dfsSerialize(root.left, rs);
            rs = dfsSerialize(root.right, rs);
            return rs;
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            System.out.print("data::" + data);
            String[] strings = data.split(",");
            List<String> stringList = Arrays.asList(strings);
            LinkedList<String> linkedList = new LinkedList<>(stringList);
            return dfsDeserialize(linkedList);
        }

        public TreeNode dfsDeserialize(LinkedList<String> linkedList) {
            if (linkedList.isEmpty()) return null;
            if (linkedList.get(0).equals("None")) {
                linkedList.remove(0);
                return null;
            }
            TreeNode node = new TreeNode(Integer.valueOf(linkedList.get(0)));
            linkedList.remove(0);
            node.left = dfsDeserialize(linkedList);
            node.right = dfsDeserialize(linkedList);
            return node;
        }


        /**
         * N皇后
         */
        int count = 0;
        boolean[] col;
        boolean[] main;
        boolean[] sub;
        int n;

        public int totalNQueens(int n) {
            this.n = n;
            this.col = new boolean[n];
            this.main = new boolean[2 * n - 1];
            this.sub = new boolean[2 * n - 1];
            countQueen(0);

            return count;
        }

        public void countQueen(int hang) {
            if (hang == n) {
                count++;
                return;
            }
            for (int j = 0; j < n; j++) {
                if (!col[j] && !main[hang - j + n - 1] && !sub[hang + j]) {
                    col[j] = true;
                    main[hang - j + n - 1] = true;
                    sub[hang + j] = true;
                    countQueen(hang + 1);

//下一层执行完后对当前行数据进行复位

                    col[j] = false;
                    main[hang - j + n - 1] = false;
                    sub[hang + j] = false;
                }
            }
        }
    }

    /**
     *
     *236 二叉树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null) return right;
        if(right == null) return left;
        if(left == null && right == null) return null;
        return root;
    }


}
