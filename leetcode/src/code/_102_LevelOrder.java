package code;

import java.util.*;


/**
 * @author 刘佳俊
 *
 * 二叉树的层序遍历
 *
 * 思路:
 *      1. 二叉树的层序遍历应该用到的是广度优先算法
 *      2. 这里我们可以使用队列来存储每一层访问的元素
 *      3. 访问一层元素时,我们需要将该元素的不为空的 子节点 放到队列中, 这里层序遍历是从左往右所以我们先放左子节点后放右子节点
 *      4. 我们在下面第二个版本中无需担心count的数值是否会进入死循环,
 *         因为我们是遍历一层的时候count就是这一层节点的数量,而且count会自减,访问下一层时我们会获取新的count值
 *
 */
public class _102_LevelOrder {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0,1);
        list.add(0,2);
        list.add(0,3);
        while(!list.isEmpty()){
            System.out.println(list.remove(0));
        }
    }

    // 自己写的,可以通过,但是性能不够好
    public List<List<Integer>> levelOrder1(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        List<Integer> valueList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> nodeList = new ArrayList<>();

        queue.add(root);

        TreeNode temp = null;


        while (!queue.isEmpty()) {
            valueList = new ArrayList<>();
            while (!queue.isEmpty()) {
                temp = queue.poll();
                nodeList.add(temp);

                valueList.add(temp.val);
            }
            list.add(valueList);

            while (!nodeList.isEmpty()) {
                TreeNode node = nodeList.remove(0);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
        }

        return list;
    }

    // 看题解后优化版本,和自己写的差不多
    public List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        List<Integer> valueList;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        TreeNode temp = null;

        while (!queue.isEmpty()) {
            valueList = new ArrayList<>();
            // 这个地方我们可以记录当前队列中的size ,代替上面版本中的while循环
            // 这样可以省去nodeList 的开销

            int count = queue.size();

            for (; count > 0; count--) {
                temp = queue.poll();
                valueList.add(temp.val);

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            list.add(valueList);
        }
        return list;
    }
}
