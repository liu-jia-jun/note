package data_structure.tree;

/**
 * @author 刘佳俊
 *
 * 二叉排序树的节点
 */
public class BinarySortNode {

    private int data;
    private BinarySortNode left;
    private BinarySortNode right;


    public void ergodic(BinarySortNode node){

         if(node.getLeft()!=null){
             ergodic(node.getLeft());
         }
        System.out.println(node);
        if(node.getRight()!=null){
            ergodic(node.getRight());
        }
    }

    public void addNode(BinarySortNode node){
        if(this.data>node.data){
            if(this.left==null){
                this.left=node;
            }else{
                this.left.addNode(node);
            }
        }else{
            if(this.right==null){
                this.right=node;
            }else{
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
