package code;

/**
 * @author 刘佳俊
 *
 * 另一棵树的子树
 *
 * 思路:
 *      1. 递归调用,回溯算法
 *      2. 先以一个节点为头节点判断subRoot树是否为当前头节点树的子树
 *      3. 如果是则返回true
 *      4. 如果不是则依次递归调用左节点和右节点作为头节点进行判断
 *
 *
 */


public class _572_IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {


        // 先判断以当前节点为头节点时,subRoot是否为root的子树
        boolean result = poccess(root, subRoot);

        // 如果以当前节点为头节点时,subRoot是root的子树,则直接返回为true
        if (result == true) {
            return result;
        }
        // 如果不是,则以当前节点的左右节点依次作为头节点进行递归调用,判断当前节点的左子树和右子树中是否存在subRoot作为子树
        // 这里的左右节点需要判空,一颗空树是没有子树的所以这里的resultL和resultR初始化的值都是false
        boolean resultL = false;
        if (root.left != null) {
            // 判断以当前节点的左节点为头节点时,subRoot是否为root的子树
            resultL = isSubtree(root.left, subRoot);
        }

        // 如果左树中存在subRoot子树,则直接返回,无需再判断右子树
        if (resultL == true) {
            return true;
        }

        boolean resultR = false;
        if (root.right != null) {
            // 判断以当前节点的左节点为头节点时,B是否为root的子树
            resultR = isSubtree(root.right, subRoot);
        }
        // 如果右数中存在subRoot子树,则直接返回
        if (resultR == true) {
            return true;
        }

        // 左右子树均没有,直接返回false
        return false;

    }


    // 该方法是在明确头节点的情况下,判断subRoot树是否是root树的子树
    public boolean poccess(TreeNode root, TreeNode subRoot) {

        // 如果两颗树都为null则相同
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }

        // 两个节点值不同也不是子树
        if (root.val != subRoot.val) {
            return false;
        }

        // 需要判断以root,和subRoot为头节点的左右子树均相等时,才判断,subRoot为root的子树
        return poccess(root.left, subRoot.left) && poccess(root.right, subRoot.right);
    }
}
