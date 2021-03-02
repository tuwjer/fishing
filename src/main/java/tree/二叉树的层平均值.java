package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*.
* 二叉树的层平均值
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。



示例 1：

输入：
    3
   / \
  9  20
    /  \
   15   7
输出：[3, 14.5, 11]
解释：
第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
* */
public class 二叉树的层平均值 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> doubles = new ArrayList();
        if (root == null) {
            return doubles;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                sum = sum + treeNode.val;
                if (treeNode.left != null) queue.offer(treeNode.left);
                if (treeNode.right != null) queue.offer(treeNode.right);
            }
            doubles.add(sum/size);
        }
        return doubles;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(二叉树的层平均值.averageOfLevels(treeNode));

    }

}
