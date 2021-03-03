package tree;

/**
 * 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
public class 打家劫舍3 {

    private int ans = 0;

    public int rob(TreeNode root) {
        if (root == null) {
            return ans;
        }
        backtrack(root);
        return ans;
    }

    public int[] backtrack(TreeNode root) {
        if (root == null) {
            return new int[]{0,0};
        }
        int[] left = backtrack(root.left);
        int[] right = backtrack(root.right);
        // 数组只有两种数字 0 表示和当前节点不相邻的最大值 1表示和当前节点相邻的最大值
        ans = Math.max((Math.max(left[0] + right[1],left[1]+right[0])),Math.max(left[0] + root.val + right[0], left[1] + right[1]));
        return new int[]{Math.max(Math.max(left[1] +right[0], left[0] + right[0]),Math.max(left[0] +right[1], left[1] + right[1])),left[0] + right[0] + root.val};
    }

}
