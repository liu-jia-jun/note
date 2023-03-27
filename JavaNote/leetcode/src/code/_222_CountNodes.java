package code;

/**
 * @author 刘佳俊
 *   完全二叉树的节点个数
 *
 *   思路:
 *       1. 我们可以使用递归版本来实现,代码简单易懂,但是没有应用到完全二叉树的性质
 *
 *       2. 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 *       并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 *       3. 二分法,如下所述
 *
 *
 *
 *
 *
 */
public class _222_CountNodes {

    // 二分法 + 位运算 + 完全二叉树
    public int countNodes(TreeNode root) {

        if(root==null){
            return 0;
        }
        // 先算出左子树和右子树的高度
        int leftLevel= process(root.left);
        int rightLevel= process(root.right);


        if(leftLevel==rightLevel){
            // 如果两棵树的高度相等,那么它的左子树就是满二叉树,此时我们只需要根据根据公式和左子树的高度来算出左子树的节点数再加上右子树的节点数
            // 右子树节点数采用递归调用原函数就可以得出
            // 这里我们采取 位运算来算某一棵完全满二叉树的节点个数
            return countNodes(root.right) + (1<<leftLevel);
        }else{
            // 如果不相等那么他的右子树就是满二叉树,之后和上述方法一样计算出节点数并返回即可
            // 注意这里是不需要 +1 加上root节点的 因为在位运算中已经加上去了
            return countNodes(root.left) + (1<<rightLevel) ;
        }
    }

    // 求一颗完全二叉树的高度
    public int process(TreeNode node){
        int level =0;
        while(node!=null){
            level++;
            node= node.left;
        }
        return level;
    }



    // 递归实现
    public int countNodes2(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }


}
