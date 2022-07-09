package code;


/**
 * @author 刘佳俊
 *
 *
 * 验证二叉搜索树
 */
public class _98_ {
    public boolean isValidBST(TreeNode root) {

        Info info = process(root);

        return info.isValidBST;
    }


    public Info process(TreeNode node) {
        if (node == null) {
            return new Info(true, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        if (leftInfo.isValidBST == false || rightInfo.isValidBST == false) {
            return new Info(false, 0L, 0L);
        }
        boolean isValidBST = leftInfo.maxValue < node.val && rightInfo.minValue > node.val ? true : false;

        Long maxValue = rightInfo.maxValue> node.val? rightInfo.maxValue : node.val;

        Long minValue = leftInfo.minValue<node.val? leftInfo.minValue : node.val;

        return new Info(isValidBST,maxValue,minValue);

    }


    class Info {
        boolean isValidBST;
        Long maxValue;
        Long minValue;

        public Info(boolean isValidBST, Long maxValue, Long minValue) {
            this.isValidBST = isValidBST;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
}
/*
  public Info process(TreeNode node) {
        if (node == null) {
            return null;
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        boolean isValidBST = false;
        int maxValue = 0;
        int minValue = 0;

        if (leftInfo == null && rightInfo == null) {
            return new Info(true, node.val, node.val);
        }

        if (leftInfo.isValidBST == false || rightInfo.isValidBST == false) {
            return new Info(false, 0, 0);
        }


        if (leftInfo == null) {

            isValidBST = rightInfo.minValue > node.val ? true : false;
            maxValue = rightInfo.minValue;
            minValue = node.val;
        }
        if (rightInfo == null) {
            isValidBST = leftInfo.maxValue < node.val ? true : false;
            minValue = leftInfo.maxValue;
            maxValue = node.val;
        }

        if (rightInfo != null && leftInfo != null) {
            isValidBST = leftInfo.maxValue < node.val && rightInfo.minValue > node.val ? true : false;
            minValue = leftInfo.minValue;
            maxValue = rightInfo.maxValue;
        }
        if (leftInfo.isValidBST == false || rightInfo.isValidBST == false) {
            return new Info(false, 0, 0);
        }
        return new Info(isValidBST, maxValue, minValue);

    }
 */