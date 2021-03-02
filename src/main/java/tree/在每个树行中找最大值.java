package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*在每个树行中找最大值
*
*您需要在二叉树的每一行中找到最大的值。

示例：

输入:

          1
         / \
        3   2
       / \   \
      5   3   9

输出: [1, 3, 9]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* */
public class 在每个树行中找最大值 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();

        if (root == null) {
            return integerList;
        }
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            Integer max = null;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeQueue.poll();
                if (treeNode.left != null) treeNodeQueue.offer(treeNode.left);
                if (treeNode.right != null) treeNodeQueue.offer(treeNode.right);
                if (max == null) max = treeNode.val;
                max = Math.max(max, treeNode.val);
            }
            integerList.add(max);
        }
        return integerList;
    }

    /**
     * 二叉搜索树的最小绝对差
     * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：
     * <p>
     * 1
     * \
     * 3
     * /
     * 2
     * <p>
     * 输出：
     * 1
     * <p>
     * 解释：
     * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
     */
    int pre = -1;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        backtrack(root);
        return min;
    }

    public void backtrack(TreeNode root) {
        if (root == null) {
            return;
        }
        backtrack(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            min = Math.min(min, root.val - pre);
            pre = root.val;
        }
        backtrack(root.right);
    }
}
