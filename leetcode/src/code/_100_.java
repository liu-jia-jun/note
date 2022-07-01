package code;

import java.util.Stack;

/**
 * @author 刘佳俊
 */
public class _100_ {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p.val!=q.val){
            return false;
        }

        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.push(p);
        stackQ.push(q);

        while(stackP.isEmpty()&&stackQ.isEmpty()){

            while(p.left!=null&&q.left!=null){
                if(p.left.val!=q.left.val){
                    return false;
                }
                p=p.left;
                q=q.left;
                stackP.push(p);
                stackQ.push(q);
            }
        }
return true;

    }
}
