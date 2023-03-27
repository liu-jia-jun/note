package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author 刘佳俊
 */
public class _145_PostorderTraversal {

    // 迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                // 头插法
                list.add(0, root.val);

                // 后访问左子树
                if (root.left != null) {
                    stack.push(root.left);
                }
                // 先访问右子树
                root = root.right;
            } else {
                root = stack.pop();
            }

        }
        return list;
    }


    // 递归
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root != null) {
            postorder(root, list);
        }
        return list;
    }

    public void postorder(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            postorder(node.left, list);
        }
        if (node.right != null) {
            postorder(node.right, list);
        }
        list.add(node.val);


    }
}
