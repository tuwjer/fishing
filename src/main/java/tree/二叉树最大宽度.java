package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最大宽度
 * <p>
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 */
public class 二叉树最大宽度 {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        int max = 0;
        treeNodeQueue.offer(root);
        index.offer(0);
        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            Integer start = index.peek();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeQueue.poll();
                Integer integer = index.poll();
                if (treeNode.left != null) {
                    treeNodeQueue.offer(treeNode.left);
                    index.offer(integer * 2);
                }
                if (treeNode.right != null) {
                    treeNodeQueue.offer(treeNode.right);
                    index.offer(integer * 2 + 1);
                }
                max = Math.max(max,integer-start+1);
            }
        }
        return max;
    }
}
