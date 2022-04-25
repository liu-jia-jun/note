package data_structure.tree;

/**
 * @author 刘佳俊
 */
public class HuffmanNode implements Comparable<HuffmanNode> {
    private Byte data;
    private Integer weight;
    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode() {
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public HuffmanNode(Byte data, Integer weight) {
        this.data = data;
        this.weight = weight;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }
}
