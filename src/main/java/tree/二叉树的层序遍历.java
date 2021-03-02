package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的层序遍历 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if (root == null) {
            return listList;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> integerList = new ArrayList<>();
            int size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeQueue.poll();
                integerList.add(treeNode.val);
                if (treeNode.left != null) treeNodeQueue.offer(treeNode.left);
                if (treeNode.right != null) treeNodeQueue.offer(treeNode.right);
            }
            listList.add(integerList);
        }
        return listList;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(二叉树的层序遍历.levelOrder(treeNode));

    }
}
