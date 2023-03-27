package code;

/**
 * @author 刘佳俊
 *
 * 树的子结构
 *
 * 思路:
 *      1. 递归调用,回溯算法
 *      2. 先以一个节点为头节点判断B树是否为当前头节点树的子结构
 *      3. 如果是则返回true
 *      4. 如果不是则依次递归调用左节点和右节点作为头节点进行判断
 *
 */
public class _offer26_IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {


        // 规定空树不为任何树的子结构
        if(B==null){
            return false;
        }

        // 先判断以当前节点为头节点时,B是否为A的子结构
        boolean result = poccess(A,B);

        // 如果以当前节点为头节点时,B是A的子结构,则直接返回为true
        if(result==true){
            return result;
        }
        // 如果不是,则以当前节点的左右节点依次作为头节点进行递归调用,判断当前节点的左子树和右子树中是否存在B作为子结构
        // 这里的左右节点需要判空,一颗空树是没有子结构的所以这里的resultL和resultR初始化的值都是false
        boolean resultL=false;
        if(A.left!=null){
            // 判断以当前节点的左节点为头节点时,B是否为A的子结构
            resultL = isSubStructure(A.left,B);
        }

        boolean resultR=false;
        if(A.right!=null){
            // 判断以当前节点的左节点为头节点时,B是否为A的子结构
            resultR = isSubStructure(A.right,B);
        }

        // 只要左或者右,有一个结构上有以B为原型的子结构,就说明B是A的子结构
        return resultL||resultR;

    }


    // 该方法是在明确头节点的情况下,判断B树是否是A树的子结构
    public boolean poccess(TreeNode A, TreeNode B){

        // 如果两颗树都为null则相同
        if(A==null&&B==null){
            return true;
        }
        // A不为null,B为null,则B树为A树的子结构
        if(B==null){
            return true;
        }
        // A为null,B不为null,则B树不是A树的子结构
        if(A==null){
            return false;
        }

        // 两个节点值不同也不是子结构
        if(A.val!=B.val){
            return false;
        }

        // 需要判断以A,和B为头节点的左右子树均相等时,才判断,B为A的子结构
        return poccess(A.left,B.left)&&poccess(A.right,B.right);
    }
}
