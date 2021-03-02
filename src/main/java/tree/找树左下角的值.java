package tree;

import java.util.LinkedList;
import java.util.Queue;

/*
*. 找树左下角的值
给定一个二叉树，在树的最后一行找到最左边的值。

示例 1:

输入:

    2
   / \
  1   3

输出:
1


示例 2:

输入:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

输出:
7
 */
public class 找树左下角的值 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList();
        if (root == null) {
            return 0;
        }
        treeNodeQueue.offer(root);
        int ans = 0;
        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeQueue.poll();
                if(i == 0){
                    ans = treeNode.val;
                }
                if (treeNode.left != null) treeNodeQueue.offer(treeNode.left);
                if (treeNode.right != null) treeNodeQueue.offer(treeNode.right);
            }
        }
        return ans;
    }
}
