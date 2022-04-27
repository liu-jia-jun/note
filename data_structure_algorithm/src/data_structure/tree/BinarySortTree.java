package data_structure.tree;

/**
 * @author 刘佳俊
 * <p>
 * 二叉排序树的删除节点
 * <p>
 * 删除节点需要分情况讨论
 * 第一种,删除的是叶子节点,
 * 此时只需要判断该叶子节点是父节点的左子节点还是右子节点
 * 如果删除的叶子节点是该叶子节点的父节点的左子节点,此时只需要将父节点的left设为null即可,右子节点同理
 * <p>
 * 第二种,删除的是非叶子节点下面还挂着一个子树(左子树或者右子树)
 * 此时我们只需要将父节点的left 或者 right 设置成该节点下的子树
 * <p>
 * 第三种,删除的是非叶子节点(target)下面还挂着两个子树(左子树和右子树)
 * 此时我们需要找到该节点的右子树中最小的一个节点,将该节点删除并将该删除的节点值赋给我们非叶子节点(即用右子树中最小的节点将需要删除的非叶子节点替换掉)
 * 因为我们在删除拥有两个子树的非叶子节点后需要保持这颗树任然仍然为排序二叉树,
 * 找到右子树中最小的节点可以保证该最小的节点大于target节点的左子树,并且小于target的右子树
 */
public class BinarySortTree {
    private BinarySortNode root;

    // 查找要删除的节点
    public BinarySortNode search(int data) {
        if (root == null) {
            return null;
        } else {
            return root.search(data);
        }
    }

    // 查找删除节点的父节点
    public BinarySortNode searchParent(int data) {
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
    public void addNode(BinarySortNode node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    public void deleteNode(int data) {
        BinarySortNode target = search(data);
        if (target == null) {
            return;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            root = null;
            return;
        }
        BinarySortNode parent = searchParent(data);
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

    public int searchMin(BinarySortNode node) {
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
