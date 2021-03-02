package tree;

/**
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 */
public class 后继者 {

    private TreeNode treeNode = null;

    private TreeNode pre = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return treeNode;
        }
        backtrack(root, p);
        return treeNode;
    }

    public void backtrack(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        backtrack(root.left, p);
        if(pre != null && pre.val == p.val ){
            treeNode = root;
        }else if(pre != null && root.val == p.val){
            treeNode = root.right;
        }
        pre = root;
        backtrack(root.right, p);
    }

}
