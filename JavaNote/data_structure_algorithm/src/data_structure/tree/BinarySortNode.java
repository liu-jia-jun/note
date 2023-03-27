package data_structure.tree;

/**
 * @author 刘佳俊
 * <p>
 * 二叉排序树的节点
 */
public class BinarySortNode {

    private int data;
    private BinarySortNode left;
    private BinarySortNode right;


    public BinarySortNode search(int data) {
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

    public BinarySortNode searchParent(int data) {
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


    public void ergodic(BinarySortNode node) {

        if (node.getLeft() != null) {
            ergodic(node.getLeft());
        }
        System.out.println(node);
        if (node.getRight() != null) {
            ergodic(node.getRight());
        }
    }

    public void addNode(BinarySortNode node) {
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


    public BinarySortNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinarySortNode getLeft() {
        return left;
    }

    public void setLeft(BinarySortNode left) {
        this.left = left;
    }

    public BinarySortNode getRight() {
        return right;
    }

    public void setRight(BinarySortNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinarySortNode{" +
                "data=" + data +
                '}';
    }
}
