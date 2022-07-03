package code;

/**
 * @author 刘佳俊
 */
public class _572_IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {


        // 先判断以当前节点为头节点时,B是否为A的子结构
        boolean result = poccess(root, subRoot);

        // 如果以当前节点为头节点时,B是A的子结构,则直接返回为true
        if (result == true) {
            return result;
        }
        // 如果不是,则以当前节点的左右节点依次作为头节点进行递归调用,判断当前节点的左子树和右子树中是否存在B作为子结构
        // 这里的左右节点需要判空,一颗空树是没有子结构的所以这里的resultL和resultR初始化的值都是false
        boolean resultL = false;
        if (root.left != null) {
            // 判断以当前节点的左节点为头节点时,B是否为A的子结构
            resultL = isSubtree(root.left, subRoot);
        }
        if (resultL == true) {
            return true;
        }

        boolean resultR = false;
        if (root.right != null) {
            // 判断以当前节点的左节点为头节点时,B是否为A的子结构
            resultR = isSubtree(root.right, subRoot);
        }
        if (resultR == true) {
            return true;
        }

        return false;

    }


    // 该方法是在明确头节点的情况下,判断B树是否是A树的子结构
    public boolean poccess(TreeNode root, TreeNode subRoot) {

        // 如果两颗树都为null则相同
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }

        // 两个节点值不同也不是子结构
        if (root.val != subRoot.val) {
            return false;
        }

        // 需要判断以A,和B为头节点的左右子树均相等时,才判断,B为A的子结构
        return poccess(root.left, subRoot.left) && poccess(root.right, subRoot.right);
    }
}
