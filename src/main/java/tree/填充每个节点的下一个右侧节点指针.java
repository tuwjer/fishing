package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class 填充每个节点的下一个右侧节点指针 {

    public Node connect(Node root) {
        Queue<Node> nodeQueue = new LinkedList<>();
        if (root == null) {
            return root;
        }
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            Node temp = null;
            for (int i = 0; i < size; i++) {
                Node node = nodeQueue.poll();
                if(temp != null){
                    temp.next = node;
                }
                if(i == size -1){
                    node.next = null;
                }
                if(node.left != null) nodeQueue.offer(node.left);
                if(node.right != null) nodeQueue.offer(node.right);
                temp = node;
            }
        }
        return root;
    }
}
