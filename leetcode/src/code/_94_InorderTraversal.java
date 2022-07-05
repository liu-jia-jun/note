package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 刘佳俊 94. 二叉树的中序遍历
 */
public class _94_InorderTraversal {


    // 递归写法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        inorderTraversal(root, list);
        return list;
    }

    public void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            inorderTraversal(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            inorderTraversal(node.right, list);
        }
    }

    // 非递归写法


    /**
     * 记住左链入栈
     * 合并版
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            // 这里的是输出节点的右子树,对右子树进行相同的操作
            root = root.right;


        }
        return list;
    }
}


