package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 刘佳俊
 */
public class _145_PostorderTraversal {

    // 迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while(true){

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
