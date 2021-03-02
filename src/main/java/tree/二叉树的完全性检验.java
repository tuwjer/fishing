package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

*二叉树的完全性检验
给定一个二叉树，确定它是否是一个完全二叉树。

百度百科中对完全二叉树的定义如下：

若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）



示例 1：



输入：[1,2,3,4,5,6]
输出：true
解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
* */
public class 二叉树的完全性检验 {

    public static boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();

        if (root == null) {
            return true;
        }
        treeNodeQueue.offer(root);
        int countFlag = 0;
        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeQueue.poll();
                if (treeNode.left == null && treeNode.right != null) {
                    return false;
                }
                if (treeNode.left != null || treeNode.right != null) {
                    if (countFlag != 0) {
                        return false;
                    }
                }
                if (treeNode.left == null || treeNode.right == null) {
                    countFlag++;
                }
                if (treeNode.left != null) treeNodeQueue.offer(treeNode.left);
                if (treeNode.right != null) treeNodeQueue.offer(treeNode.right);
            }
        }
        return true;

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(5);
        System.out.println(isCompleteTree(treeNode));
    }

}
