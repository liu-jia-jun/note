package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 刘佳俊
 *
 * 二叉树的层序遍历 II
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 *
 * 思路:
 *      1. 属于二叉树的层序遍历问题
 *      2. 二叉树层序遍历,我们需要接用的队列,并记录每层的元素的个数就能很好的去遍历完整个二叉树
 *      3. 这里说的自定向上的层序遍历,其实我们只需要在往返回的List集合添加list元素的时候使用头插法,就可以达到自底向上的效果
 *
 */
public class _107_LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> valueList;

        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            count = queue.size();
            valueList = new ArrayList<>();
            while (count > 0) {

                TreeNode node = queue.poll();
                valueList.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            list.add(0,valueList);
        }
        return list;
    }
}
