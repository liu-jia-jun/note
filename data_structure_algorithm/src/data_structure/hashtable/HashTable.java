package data_structure.hashtable;

import java.util.HashMap;

/**
 * @author 刘佳俊
 */
public class HashTable {

    private int maxSize = 10;


    Node[] nodeList;

    public HashTable() {
        nodeList = new Node[maxSize];
        for (int i = 0; i < maxSize; i++) {
            nodeList[i] = null;
        }
    }

    public HashTable(int maxSize) {
        this.maxSize = maxSize;
        nodeList = new Node[maxSize];
        for (int i = 0; i < maxSize; i++) {
            nodeList[i] = null;
        }
    }


    public int getHashValue(int id) {
        return id / maxSize;
    }


    public void add(Node node) {
        int hashValue = getHashValue(node.getId());
        if (nodeList[hashValue] == null) {
            nodeList[hashValue] = node;
        } else {
            node.setNext(nodeList[hashValue].getNext());
            nodeList[hashValue] = node;

        }
    }

    public void show() {
        Node temp;
        for (int i = 0; i < maxSize; i++) {
            temp = nodeList[i];
            while (temp != null) {
                System.out.println(temp);
                temp = temp.getNext();
            }
        }
    }

    public void delete(int id) {
        Node temp = nodeList[getHashValue(id)];
        if (temp.getId() == id) {
            nodeList[getHashValue(id)] = temp.getNext();
            return;
        }


        while (temp.getNext() != null) {
            if (temp.getNext().getId() == id) {
                temp.setNext(temp.getNext().getNext());
                return;
            }
        }
    }

    public void update(int id, Object data) {
        Node temp = nodeList[getHashValue(id)];


        while (temp != null) {
            if (temp.getId() == id) {
                temp.setData(data);
                return;
            }
        }

    }


}
