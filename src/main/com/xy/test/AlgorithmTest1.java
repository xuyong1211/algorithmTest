package main.com.xy.test;

import java.util.*;

public class AlgorithmTest1 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * <p>
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/move-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }

        }
    }

    /**
     * 11 盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点?(i,?ai) 。在坐标内画 n 条垂直线，垂直线 i?的两个端点分别为?(i,?ai) 和 (i, 0) 。找出其中的两条线，使得它们与?x?轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器。
     */

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            int i = right - left;
            area = height[left] < height[right] ?
                    Math.max(area, i * height[left++]) :
                    Math.max(area, i * height[right--]);
//            int min = Math.min(height[left], height[right]);
//            int tempArea = min * (right - left);
//            if(tempArea >= area){
//                area = tempArea;
//            }
//             if(height[left]< height[right]){
//                 left++;
//             }else {
//                 right--;
//             }
        }

        return area;
    }

    /**
     * 70 爬楼梯
     * 假设你正在爬楼梯。需要 n?阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     */
    public int climbStairs(int n) {
        int amount = 0;
        int firstValue = 1;
        int secondValue = 2;
        if (n == 2) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        for (int i = 1; i <= n - 2; i++) {
            amount = firstValue + secondValue;
            firstValue = secondValue;
            secondValue = amount;
        }
        return amount;
    }

    /**
     * 15 三数之和
     * 给你一个包含 n 个整数的数组?nums，判断?nums?中是否存在三个元素 a，b，c ，使得?a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        LinkedList<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i != 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            int head = i + 1;
            int tail = nums.length - 1;
            int target = -nums[i];
            while (head < tail) {
                int sum = nums[head] + nums[tail];
                if (target == sum) {
                    List<Integer> integerList = Arrays.asList(nums[i], nums[head], nums[tail]);
                    result.add(integerList);
//                    integerList.sort(Comparator.naturalOrder());
                    while (head < tail && nums[head] == nums[head + 1]) {
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail - 1]) {
                        tail--;
                    }
                    head++;
                    tail--;
                } else if (target >= sum) {
                    head++;
                } else {
                    tail--;
                }
            }

        }
        return result;
    }

    /**
     * 141 环形链表给定一个链表，判断链表中是否有环。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *
     * 如果链表中存在环，则返回 true 。 否则，返回 false
     *
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || slow == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;


        }
        return true;
    }

    /**
     * 1 两数之和
     *hash 表解法
    *
     */

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            Integer integer = map.get(j);
            if(integer == null){
                map.put(integer,integer);
            }else {
                return new int[]{i,integer};
            }
        }
        return  null;
    }


/**
 * 20 有效括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'?的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
* */

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(aChar == '('){
                stack.push(')');
            }else if(aChar == '['){
                stack.push(']');
            }else if(aChar == '{'){
                stack.push('}');
            }else if(stack.empty() || aChar != (char)stack.pop()){
                return false;
            }
        }
        return stack.empty();//pop 会出栈
    }


    /**
     * 242 有效的字母已异位词
     *
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>();
        for (char aChar : chars) {
            Integer integer = hashMap.get(aChar);
            if (integer == null) {
                hashMap.put(aChar , 1);
            } else {
                hashMap.put(aChar , integer + 1);
            }
        }
        char[] chars1 = t.toCharArray();
        for (char c : chars1) {
            Integer integer = hashMap.get(c);
            if (integer == null) {
                return false;
            } else if (integer > 0) {
                int d = integer -1 ;
                if(d == 0){
                    hashMap.remove(c );
                }else {
                    hashMap.put(c, d);
                }

            } else {
                hashMap.remove(c );
            }
        }
        return hashMap.isEmpty();


    }


    /**
     * 94 二叉树的中序遍历
     *
     */
    public class TreeNode {
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
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null){
            countIntegerInOrder(root);
        }
        return list;
    }


    public void countIntegerInOrder(TreeNode root){
        if(root == null) return ;
        if(root.left != null){
            countIntegerInOrder(root.left);
        }
        list.add(root.val);
        if(root.right != null){
            countIntegerInOrder(root.right);
        }
    }

    /**
     * 144 二叉树的前序遍历
     *
     *
     */
        public List<Integer> preorderTraversal(TreeNode root) {
            if(root!=null){
                countIntegerPreOrder(root);
            }
            return list;
        }

        public void countIntegerPreOrder(TreeNode root){
            list.add(root.val);
            if(root.left != null){
                countIntegerPreOrder(root.left);
            }
            if(root.right != null){
                countIntegerPreOrder(root.right);
            }
        }

    /**
     * 145 二叉树的后序遍历
     *
     */

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root != null) {
            countIntegerPostorder(root);
        }
        return list;
    }

    public void countIntegerPostorder (TreeNode root){
        if(root.left!=null){
            countIntegerPostorder(root.left);
        }
        if(root.right != null){
            countIntegerPostorder(root.right);
        }
        list.add(root.val);
    }
    /**
     * 590 N叉树的后序遍历
     *
     */

    class NNode {
    public int val;
    public List<NNode> children;

    public NNode() {}

    public NNode(int _val) {
        val = _val;
    }

    public NNode(int _val, List<NNode> _children) {
        val = _val;
        children = _children;
    }
}
    public List<Integer> postorder(NNode root) {
        countIntegerN(root);
        return list;
    }

    public void countIntegerN(NNode root){
        if(root == null) return;
        if(root.children != null){
            for (NNode child : root.children) {
                countIntegerN(child);
            }
        }
        list.add(root.val);
    }

    /**
     * 589 N叉树的前序遍历
     *
     */

    public List<Integer> preorder(NNode root) {
        countIntegerNPost(root);
        return list;
    }

    public void countIntegerNPost(NNode root) {
        if(root == null) return;
        list.add(root.val);
        if(root.children != null){
            for (NNode child : root.children) {
                countIntegerNPost(child);
            }
        }
    }

    /**
     * 剑指offer 49 抽数
     *
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     *
     * ?
     */

    public int nthUglyNumber(int n) {
        int a = 0 ,b = 0 ,c = 0;
        int[] uglys = new int[n];
        uglys[0] = 1;
        for (int i = 1; i < n; i++) {
            uglys[i] = Math.min(Math.min(uglys[a]*2,uglys[b]*3),uglys[c]*5);
            if(uglys[a]*2 <= uglys[i]) a++;
            if(uglys[b]*3 <= uglys[i]) b++;
            if(uglys[c]*5 <= uglys[i]) c++;
        }

        return uglys[n-1];
    }

    /**
     * 剑指offer40 最小的K个数
     *
     */

    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0)return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if(i < k){
                queue.offer(arr[i]);
            }else {
                Integer peek = queue.peek();
                if(peek > arr[i]){
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }
        int[] returns = new int[queue.size()];
        int j = 0 ;
        for (Integer integer : queue) {
            returns[j++] = integer;
        }
        return returns;
    }

    /**
     * 347 前K个 高频元素
     * @param nums
     * @param k
     * @return
     */

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if(count == null){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],++count);
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        Set<Integer> integers = map.keySet();
        int size = integers.size();
        int j = 0;
        for (Integer integer : integers) {
            if(j < k){
                queue.offer(integer);
            }else {
                if(map.get(queue.peek()) < map.get(integer)){
                    queue.poll();
                    queue.offer(integer);
                }
            }
            j++;
        }
        int i = 0;
        int[] returns = new int[queue.size()];
        for (Integer integer : queue) {
            returns[i] = integer.intValue();
            i++;
        }
        return returns;
    }
    /**
     * 102 二叉树的层序遍历
     *
     */

    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        countNode(root,0);
        Set<Integer> integers = hashMap.keySet();
        List<List<Integer>> returns = new ArrayList<>();
        for (Integer integer : integers) {
            returns.add(hashMap.get(integer));
        }
        return returns;
    }


    public void countNode(TreeNode node,int deep) {
        if(node == null) return;

        if(hashMap.get(deep) == null){
            List<Integer> objects = new ArrayList<>();
            objects.add(node.val);
            hashMap.put(deep,objects);
        }else {
            List<Integer> integerList = hashMap.get(deep);
            integerList.add(node.val);
            hashMap.put(deep,integerList);
        }
        ++deep;
        countNode(node.left,deep);
        countNode(node.right,deep);

    }

    /**
     * 429 N叉树的层序遍历
     */
    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> returns = new ArrayList<>();
        countNode(returns,root,0);
//        Set<Integer> integers = hashMap.keySet();
//        for (Integer integer : integers) {
//            returns.add(hashMap.get(integer));
//        }
        return returns;
    }


    public void countNode( List<List<Integer>> returns,Node node,int deep) {
        if(node == null) return;
        if(returns.size() -1 <deep){
            returns.add(new ArrayList<>());
        }
        returns.get(deep).add(node.val);
//        if(hashMap.get(deep) == null){
//            List<Integer> objects = new ArrayList<>();
//            objects.add(node.val);
//            hashMap.put(deep,objects);
//        }else {
//            List<Integer> integerList = hashMap.get(deep);
//            integerList.add(node.val);
//            hashMap.put(deep,integerList);
//        }
        ++deep;
        for (Node child : node.children) {
            countNode(returns,child,deep);
        }


    }
}
