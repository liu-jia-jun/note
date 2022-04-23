package data_structure.tree;

/**
 * @author 刘佳俊
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        /**
         //先需要创建一颗二叉树
         BinaryTree binaryTree = new BinaryTree();
         //创建需要的结点
         Node root = new Node(1);
         Node node2 = new Node(2);
         Node node3 = new Node(3);

         Node node4 = new Node(4);
         Node node5 = new Node(5);
         //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
         root.setLeft(node2);
         root.setRight(node3);
         node3.setLeft(node4);
         node3.setRight(node5);
         binaryTree.setRoot(root);

         System.out.println("前序遍历"); // 1,2,3,4,5
         binaryTree.preOrder();

         System.out.println("中序遍历");
         binaryTree.infixOrder(); // 2,1,5,3,4

         System.out.println("后序遍历");
         binaryTree.postOrder(); // 2,5,4,3,1

         System.out.println("前序遍历查找");
         System.out.println(binaryTree.preOrderSearch(6));
         System.out.println("中序遍历查找");
         System.out.println(binaryTree.infixOrderSearch(5));
         System.out.println("后序遍历查找");
         System.out.println(binaryTree.postOrderSearch(5));

         binaryTree.deleteNode(3);
         binaryTree.preOrder();
         */

        ThreadeNode root = new ThreadeNode(1);
        ThreadeNode node2 = new ThreadeNode(2);
        ThreadeNode node3 = new ThreadeNode(3);
        ThreadeNode node4 = new ThreadeNode(4);
        ThreadeNode node5 = new ThreadeNode(5);


        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);

        ThreadeBinaryTree threadeBinaryTree = new ThreadeBinaryTree();
        threadeBinaryTree.setRoot(root);
        threadeBinaryTree.threadeTree();

        System.out.println(root);
        threadeBinaryTree.threadedList();

    }
}

