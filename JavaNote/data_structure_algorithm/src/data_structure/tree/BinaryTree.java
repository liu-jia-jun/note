package data_structure.tree;

/**
 * @author 刘佳俊
 *
 * 二叉树的实现
 */
public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public BinaryTree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    // 前序遍历

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("该二叉树为空");
        }
    }


    // 中序遍历

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("该二叉树为空");
        }
    }

    // 后序遍历

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("该二叉树为空");
        }
    }
    // 前序遍历查找

    public Node preOrderSearch(int data) {
        if (this.root != null) {
            return this.root.preOrderSearch(data);
        } else {
            System.out.println("该二叉树为空");
            return null;
        }
    }


    // 中序遍历

    public Node infixOrderSearch(int data) {
        if (this.root != null) {
            return this.root.infixOrderSearch(data);
        } else {
            System.out.println("该二叉树为空");
            return null;
        }
    }

    // 后序遍历

    public Node postOrderSearch(int data) {
        if (this.root != null) {
           return this.root.postOrderSearch(data);
        } else {
            System.out.println("该二叉树为空");
            return null;
        }
    }

    // 删除节点
    public void deleteNode(int data){
        if(root==null){
            System.out.println("该树为空");
            return;
        }
        if(root.getData()==data){
            root = null;
            return;
        }
        root.deleteNode(data);

    }
}
