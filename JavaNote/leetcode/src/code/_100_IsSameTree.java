package code;

import java.util.Stack;

/**
 * @author 刘佳俊
 * <p>
 * 判断两棵二叉树是否相等
 */
public class _100_IsSameTree {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }


       if(p.val==q.val){
           return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
       }
       return false;
    }
}
