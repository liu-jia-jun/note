package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 刘佳俊 144. 二叉树的前序遍历
 */
public class _144_InorderTraversal {


    // 迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        // 先根节点,再左子树
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 再右子树
            root = root.right;
        }
        return list;

    }

    // 递归
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            preorder(root, list);
        }
        return list;

    }

    public void preorder(TreeNode node, List<Integer> list) {
        list.add(node.val);
        if (node.left != null) {
            preorder(node.left, list);
        }

        if (node.right != null) {
            preorder(node.right, list);
        }
    }
}

