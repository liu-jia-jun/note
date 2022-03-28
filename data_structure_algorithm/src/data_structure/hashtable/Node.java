package data_structure.hashtable;

/**
 * @author 刘佳俊
 */
public class Node {
    private int id;
    private Object data;
    private Node next = null;

    public Node() {
        id=0;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Node(int hashValue, Object data) {
        this.id=hashValue;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
