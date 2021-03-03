package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 层数最深叶子节点的和
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *
 *
 * 提示：
 *
 * 树中节点数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 */
public class 层数最深叶子节点的和 {
    private int ans = 0;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            ans = 0;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeQueue.poll();
                ans = ans + treeNode.val;
                if (treeNode.left != null) treeNodeQueue.offer(treeNode.left);
                if (treeNode.right != null) treeNodeQueue.offer(treeNode.right);
            }
        }
        return ans;
    }
}
