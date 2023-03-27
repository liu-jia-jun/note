package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 刘佳俊
 *
 * 奇偶树
 *
 * 思路:
 *      1. 类似于二叉树或者N叉树的层序遍历,我们都可以使用广度优先算法
 *      2. 本题和二叉树的层序遍历类似,只需要多加几个判断
 *      3. 这里我们需要一个队列来存储某一层的所有节点,然后遍历这个队列
 *      4. 遍历的过程中判断是否符合奇偶数的要求,
 *      5. 不符合则直接返回false 符合则将这个节点的不为空的子节点放入到队列中,作为下次遍历的队列元素
 *
 */
public class _1609_IsEvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

//        List<Integer> list = new ArrayList<>();

        int pre=-1;
        queue.add(root);

        TreeNode nodeTemp;
        int level = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                nodeTemp = queue.poll();
                count--;


                if (nodeTemp.val % 2 == level) {
                    return false;
                }
                if (level == 0 && pre!=-1&&nodeTemp.val <= pre) {

                        return false;

                }
                if (level == 1 && pre!=-1&&nodeTemp.val >= pre) {

                        return false;

                }
               pre=nodeTemp.val;
                if(nodeTemp.left!=null){
                    queue.add(nodeTemp.left);
                }
                if(nodeTemp.right!=null){
                    queue.add(nodeTemp.right);
                }
            }
           pre=-1;
            level = level==1?0:1;

        }
        return true;

    }
}
