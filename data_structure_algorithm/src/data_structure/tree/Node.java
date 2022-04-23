package data_structure.tree;

/**
 * @author 刘佳俊
 */
public class Node implements Comparable<Node> {

    private Node left = null;
    private Node right = null;
    private int data;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    // 前序遍历查找
    public Node preOrderSearch(int data) {

        if (this.data == data) {

            return this;
        }
        Node temp = null;
        if (this.left != null) {
            temp = this.left.preOrderSearch(data);
        }
        if (this.right != null && temp == null) {
            temp = this.right.preOrderSearch(data);
        }

        return temp;
    }

    // 中序遍历查找
    public Node infixOrderSearch(int data) {

        Node temp = null;
        if (this.left != null) {
            temp = this.left.infixOrderSearch(data);
        }

        if (temp == null && this.data == data) {

            return this;
        }
        if (temp == null && this.right != null) {
            temp = this.right.infixOrderSearch(data);
        }
        return temp;
    }

    // 后序遍历查找
    public Node postOrderSearch(int data) {

        Node temp = null;
        if (this.left != null) {
            temp = this.left.postOrderSearch(data);
        }

        if (temp == null && this.right != null) {
            temp = this.right.postOrderSearch(data);
        }

        if (temp == null && this.data == data) {

            return this;
        }
        return temp;
    }


    public void deleteNode(int data) {
        if (this.left != null && this.left.data == data) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.data == data) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.deleteNode(data);
        }
        if (this.right != null) {
            this.right.deleteNode(data);
        }

    }

    @Override
    public int compareTo(Node o) {
        return this.data-o.data;
    }
}
