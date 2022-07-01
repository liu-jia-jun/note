package code;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * @author 刘佳俊
 *
 * 二叉树的层序遍历
 */
public class _102_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> listNode = new ArrayList<>();


        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new PriorityQueue<>();


        queue.add(root);
        while (queue.isEmpty()) {
            root = queue.poll();
            listNode.add(root.val);

            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }

        }

        return list;

    }
}
