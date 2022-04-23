package data_structure.tree;

/**
 * @author 刘佳俊
 */
public class ThreadeBinaryTree {
    private ThreadeNode root;
    private ThreadeNode pre = null;

    public ThreadeNode getRoot() {
        return root;
    }

    public void setRoot(ThreadeNode root) {
        this.root = root;
    }

    public ThreadeNode getPre() {
        return pre;
    }

    public void setPre(ThreadeNode pre) {
        this.pre = pre;
    }

    public ThreadeBinaryTree() {
    }

    public ThreadeBinaryTree(ThreadeNode root) {
        this.root = root;
    }

    public void threadeTree() {
        if (this.root == null) {
            System.out.println("这他妈的是棵空树");
        } else {
            threadeNode(this.root);
        }
    }

    public void threadeNode(ThreadeNode node) {
        if (node == null) {
            return;
        }
        //线索化左子树
        threadeNode(node.getLeft());
        // 线索化当前节点
        // 注意我们这里线索化节点指的是将那些节点的左右子节点为空的节点的指针指向前驱或者后继节点,如果一个节点的子节点不为空则不需要操作
        // 第一步处理前驱节点
        if (node.getLeft() == null) {
            node.setLeft(this.pre);
            node.setLeftType(1);
        }

        // 第二步处理后驱节点
        // 处理后驱节点相当于将当前节点的右子节点指向当前节点的后驱节点
        // 也可以理解成将当前节点看做当前节点的后继节点的前驱节点,此时将后继节点的前驱节点(即当前节点)的右子节点指向当前节点的后继节点
        // 并且要保证实在当前节点的右子节点为空并且前驱节点不为空
        if (this.pre != null && this.pre.getRight() == null) {
            this.pre.setRight(node);
            this.pre.setRightType(1);
        }

        // 第三步将前驱节点置为当前节点,因为当前节点为当前节点的后继节点的前驱节点
        this.pre = node;

        //线索化右子树
        threadeNode(node.getRight());
    }

    public void threadedList(){

        ThreadeNode node = this.root;

        while(node!=null){
            while(node.getLeftType()==0){
                node=node.getLeft();
            }
            System.out.println(node);
            while(node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }

            node=node.getRight();
        }

    }


}
