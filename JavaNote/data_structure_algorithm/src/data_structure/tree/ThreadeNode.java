package data_structure.tree;

/**
 * @author 刘佳俊
 */
public class ThreadeNode {

    private ThreadeNode left = null;

    @Override
    public String toString() {
        return "ThreadeNode{" +

                "data=" + data +
                '}';
    }

    private ThreadeNode right = null;
    private int leftType = 0;
    private int rightType = 0;
    private int data;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public ThreadeNode(int data) {


        this.data = data;
    }

    public ThreadeNode() {
    }


    public ThreadeNode getLeft() {
        return left;
    }

    public void setLeft(ThreadeNode left) {
        this.left = left;
    }

    public ThreadeNode getRight() {
        return right;
    }

    public void setRight(ThreadeNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}
