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
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        stack.add(temp);
        while (!stack.isEmpty()) {
            while (temp.left != null) {
                temp = temp.left;
                stack.add(temp);

            }
            TreeNode node = stack.pop();
            list.add(node.val);

            temp = temp.right;
        }


        return list;
    }
}


