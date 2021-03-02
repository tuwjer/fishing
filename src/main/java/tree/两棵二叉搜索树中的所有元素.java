package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * 给你 root1 和 root2 这两棵二叉搜索树。
 *
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * 示例 2：
 *
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * 输出：[-10,0,0,1,2,5,7,10]
 * 示例 3：
 *
 * 输入：root1 = [], root2 = [5,1,7,0,2]
 * 输出：[0,1,2,5,7]
 * 示例 4：
 *
 * 输入：root1 = [0,-10,10], root2 = []
 * 输出：[-10,0,10]
 * 示例 5：
 *
 *
 *
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 */
public class 两棵二叉搜索树中的所有元素 {

    private List<Integer> integerList = new ArrayList<>();
    private TreeNode treeNodeTemp1;
    private TreeNode treeNodeTemp2;

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        return integerList;
    }

    public void backtrack(TreeNode root1,TreeNode root2){

    }


}
