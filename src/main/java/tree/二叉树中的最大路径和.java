package tree;

/**
 *
 *二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 */
public class 二叉树中的最大路径和 {
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return ans;
        }
        backtrack(root);
        return ans;
    }

    public int backtrack(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = backtrack(root.left);
        int right = backtrack(root.right);
        int curMax = Math.max(root.val, Math.max(Math.max(left + root.val, right + root.val), left + right + root.val));
        ans = Math.max(ans, curMax);
        return Math.max(root.val, Math.max(left + root.val, right + root.val));
    }
}
