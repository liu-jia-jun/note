package data_structure.tree;

/**
 * @author 刘佳俊
 */
public class AVLTree {
    private AVLNode root;








    // 查找要删除的节点
    public AVLNode search(int data) {
        if (root == null) {
            return null;
        } else {
            return root.search(data);
        }
    }

    // 查找删除节点的父节点
    public AVLNode searchParent(int data) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(data);
        }
    }

    // 遍历
    public void ergodic() {
        if (root == null) {
            System.out.println("这他妈的是棵空树");
        } else {
            root.ergodic(root);
        }
    }

    // 添加
    public void addNode(AVLNode node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    public void deleteNode(int data) {
        AVLNode target = search(data);
        if (target == null) {
            return;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            root = null;
            return;
        }
        AVLNode parent = searchParent(data);
        if (target.getLeft() == null && target.getRight() == null) {
            if (parent.getData() > data) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        } else if (target.getLeft() != null && target.getRight() != null) {
            int min = searchMin(target.getRight());
            target.setData(min);
        } else {
            // 删除节点下还有一颗子树时,需要判断删除的这个节点的父节点是否为空
            // 因为我们删除的这个节点可能为root节点,此时上面对是否为root节点的判断就会失效,且操作也不同
            if (parent != null) {
                if (parent.getData() > data) {
                    if (target.getLeft() != null) {
                        parent.setLeft(target.getLeft());
                    } else {
                        parent.setLeft(target.getRight());
                    }
                } else {
                    if (target.getLeft() != null) {
                        parent.setRight(target.getLeft());
                    } else {
                        parent.setRight(target.getRight());
                    }
                }
            } else {
                // 如果非叶子节点为root节点此时只需要将非叶子节点的左子树或者右子树复制给root即可
                root = target.getLeft() != null ? target.getLeft() : target.getRight();
            }
        }
    }

    public int searchMin(AVLNode node) {
        while (true) {
            if (node.getLeft() != null) {
                node = node.getLeft();
            } else {
                break;
            }
        }
        int data = node.getData();
        deleteNode(data);
        return data;
    }
}
