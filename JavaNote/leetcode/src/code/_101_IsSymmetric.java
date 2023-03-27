package code;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 刘佳俊
 */
public class _101_IsSymmetric {


    // 题解版本,仅供参考
    //TODO
    public boolean isSymmetric4(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }

        return true;
    }

    // 迭代实现   有问题
    public boolean isSymmetric(TreeNode root) {

        //TODO

        List<TreeNode> list = new LinkedList<>();
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }

        list.add(root.left);
        list.add(root.right);
        while (!list.isEmpty()) {
            int count = list.size();
            while (count > 0) {
                TreeNode node1 = list.remove(0);
                TreeNode node2 = list.remove(count - 1);
                if (node1 == null && node2 == null) {
                    count -= 2;
                    continue;
                }
                if (node1 == null || node2 == null) {
                    return false;
                }
                if (node1.val != node2.val) {
                    return false;
                }

                list.add(node1.left);
                list.add(node1.right);
                list.add(node2.left);
                list.add(node2.right);

                count -= 2;
            }

        }


        return true;
    }


    // 递归实现
    public boolean isSymmetric2(TreeNode root) {
        return isSymmetricNode(root.left, root.right);

    }

    public boolean isSymmetricNode(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }

        return isSymmetricNode(node1.left, node2.right) && isSymmetricNode(node1.right, node2.left);
    }
}
