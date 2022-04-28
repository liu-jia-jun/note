package data_structure.tree;

/**
 * @author 刘佳俊
 */
public class AVLNode {
    private int data;
    private AVLNode left;
    private AVLNode right;


    // 获取左子树的高度
    public int leftHeight() {
        return left == null ? 0 : right.height();
    }

    // 获取右子树的高度
    public int rightHeight() {
        return right == null ? 0 : right.height();
    }

    // 获取这棵树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    // 左旋转
    public void leftRotate() {
        AVLNode newNode = new AVLNode(this.data);
        newNode.left = this.left;
        newNode.right = this.right.left;
        this.data = this.right.data;
        this.right = this.right.right;
        this.left = newNode;
    }

    // 右旋转
    public void rightRotate() {
        AVLNode newNode = new AVLNode(this.data);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.data = this.left.data;
        this.left = this.left.left;
        this.right = newNode;
    }


    public AVLNode search(int data) {
        if (this.data == data) {
            return this;
        } else {
            if (this.data > data) {
                return this.getLeft() != null ? this.getLeft().search(data) : null;
            } else {
                return this.getRight() != null ? this.getRight().search(data) : null;
            }
        }
    }

    public AVLNode searchParent(int data) {
        if (this.getLeft() != null && this.getLeft().getData() == data || this.getRight() != null && this.getRight().getData() == data) {
            return this;
        } else {
            if (this.getData() > data) {
                return this.getLeft() != null ? this.getLeft().searchParent(data) : null;
            } else {
                return this.getRight() != null ? this.getRight().searchParent(data) : null;
            }
        }
    }


    public void ergodic(AVLNode node) {

        if (node.getLeft() != null) {
            ergodic(node.getLeft());
        }
        System.out.println(node);
        if (node.getRight() != null) {
            ergodic(node.getRight());
        }
    }

    public void addNode(AVLNode node) {
        if (this.data > node.data) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.addNode(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }
        }

        //当添加完一个结点后，如果: (右子树的高度-左子树的高度) > 1 , 左旋转
        if (rightHeight() - leftHeight() > 1) {
            //如果它的右子树的左子树的高度大于它的右子树的右子树的高度
            if (right != null && right.leftHeight() > right.rightHeight()) {
                //先对右子结点进行右旋转
                right.rightRotate();
            }
            //然后在对当前结点进行左旋转
            leftRotate();
            return; //必须要!!!
        }
        //当添加完一个结点后，如果 (左子树的高度 - 右子树的高度) > 1, 右旋转
        if (leftHeight() - rightHeight() > 1) {
            //如果它的左子树的右子树高度大于它的左子树的高度
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //先对当前结点的左结点(左子树)->左旋转
                left.leftRotate();

            }
            //再对当前结点进行右旋转
            rightRotate();
        }
    }


    public AVLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "data=" + data +
                '}';
    }
}
