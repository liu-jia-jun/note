package code;

/**
 * @author 刘佳俊
 */
public class _701_ {


    // 迭代实现
    public TreeNode insertIntoBST1(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode temp = root;
        while (true) {
            if (val > temp.val) {
                if (temp.right != null) {
                    temp = temp.right;
                } else {
                    temp.right = new TreeNode(val);
                    break;
                }
            } else {
                if (temp.left != null) {
                    temp = temp.left;
                } else {
                    temp.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            new TreeNode(val);
        }
        process(root, val);
        return root;
    }

    private void process(TreeNode node, int val) {
        if (node.val > val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                process(node.left, val);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                process(node.right, val);
            }
        }
    }
}
