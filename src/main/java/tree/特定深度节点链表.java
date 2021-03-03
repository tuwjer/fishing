package tree;

import java.util.*;

/**
 * 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 */
public class 特定深度节点链表 {


    public static ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null){
            return new ListNode[]{};
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(tree);
        List<ListNode> listNodeList = new ArrayList<>();
        while (!treeNodeQueue.isEmpty()){
            int size = treeNodeQueue.size();
            ListNode listNode = null;
            for(int i = 0 ; i< size ; i++){
                TreeNode treeNode = treeNodeQueue.poll();
                // 尾插法
                if(listNode == null){
                    listNode = new ListNode(treeNode.val);
                }else {
                    if(listNode.next == null){
                        listNode.next = new ListNode(treeNode.val);
                    }else {
                        ListNode temp = listNode.next;
                        while (temp.next != null){
                            temp = temp.next;
                        }
                        temp.next = new ListNode(treeNode.val);
                    }
                }
                if(treeNode.left != null) treeNodeQueue.offer(treeNode.left);
                if(treeNode.right != null) treeNodeQueue.offer(treeNode.right);
            }
            listNodeList.add(listNode);
        }
        return listNodeList.toArray(new ListNode[listNodeList.size()]);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(5);
        System.out.println(listOfDepth(treeNode));
    }
}
