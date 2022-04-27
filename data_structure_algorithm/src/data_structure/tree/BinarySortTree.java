package data_structure.tree;

/**
 * @author 刘佳俊
 */
public class BinarySortTree {
    private BinarySortNode root;

    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.addNode(new BinarySortNode(1));
        binarySortTree.addNode(new BinarySortNode(6));
        binarySortTree.addNode(new BinarySortNode(3));
        binarySortTree.addNode(new BinarySortNode(4));
        binarySortTree.ergodic();
    }

    public void ergodic() {
        if (root == null) {
            System.out.println("这他妈的是棵空树");
        } else {
            root.ergodic(root);
        }
    }

    public void addNode(BinarySortNode node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }


}
