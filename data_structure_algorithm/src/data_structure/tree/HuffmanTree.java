package data_structure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 刘佳俊
 * 构建一棵最优的赫夫曼树
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        root.infixOrder();
    }

    public static Node createHuffmanTree(int[] arr) {
        List<Node> list = new ArrayList<>();
        // 将数组中的值作为新节点的权进行创建节点并添加到list中去
        for (int i = 0; i < arr.length; i++) {
            list.add(new Node(arr[i]));
        }
        while (list.size() > 1) {
            // 将这些节点根据data值进行排序
            Collections.sort(list);
            Node node1 = list.remove(0);
            Node node2 = list.remove(0);
            Node root = new Node(node1.getData() + node2.getData());
            root.setLeft(node1);
            root.setRight(node2);
            list.add(root);
        }
        return list.remove(0);
    }


}
