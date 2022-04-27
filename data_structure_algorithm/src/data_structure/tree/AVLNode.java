package data_structure.tree;

/**
 * @author 刘佳俊
 */
public class AVLNode {
    private int data;
    private AVLNode left;
    private AVLNode right;


    public int leftHeight(){
        return left==null?0:right.height();
    }
    public int rightHeigiht(){
        return right==null?0:right.height();
    }
    public int height(){
        return Math.max(left==null?0:left.height(), right==null?0: right.height())+1;
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
