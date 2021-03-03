package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 */
public class 寻找重复的子树 {
    private Map<String, Integer> count = new HashMap<>();
    private List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null){
            return ans;
        }
        backtrack(root);
        return ans;
    }

    public String backtrack(TreeNode root){
        if(root == null){
            return "#";
        }
        String swap = root.val + "," + backtrack(root.left) + "," +backtrack(root.right);
        count.put(swap,count.getOrDefault(swap,0)+1);
        if (count.get(swap) == 2){
            ans.add(root);
        }
        return swap;
    }
}
