package data_structure.tree;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TransferQueue;

/**
 * @author 刘佳俊
 * <p>
 * 数据压缩
 */
public class HuffmanCodeTree {

    public static void main(String[] args) {
        String str = "hello world";


        byte[] bytes = huffmanZip(str);
        byte[] decode = decode(huffmanCodes, bytes);

        System.out.println(new String(decode));

    }


    //解压


    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        //1. 先得到 huffmanBytes 对应的 二进制的字符串 ， 形式 1010100010111...
        StringBuilder stringBuilder = new StringBuilder();
        //将 byte 数组转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        //把字符串安装指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行调换，因为反向查询 a->100 100->a
        Map<String, Byte> map = new HashMap<String, Byte>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //创建要给集合，存放 byte
        List<Byte> list = new ArrayList<>();
        //i 可以理解成就是索引,扫描 stringBuilder
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            // 小的计数器
            boolean flag = true;
            Byte b = null;
            while (flag) {
                //1010100010111... //递增的取出 key 1
                String key = stringBuilder.substring(i, i + count);
                //i 不动，让 count 移动，指定匹配到一个字符
                b = map.get(key);
                if (b == null) {
                    //说明没有匹配到
                    count++;
                } else {
                    //匹配到
                    flag = false;
                }
            }
            list.add(b);
            //i 直接移动到 count
            i += count;

        }
        //当 for 循环结束后，我们 list 中就存放了所有的字符 "i like like like java do you like a java" //把 list 中的数据放入到 byte[] 并返回
        byte b[] = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }


    private static String byteToBitString(boolean flag, byte b) {
        // 使用变量保存b
        int temp = b;// 将b转成int
        // 如果是正数我们还存在补高位

        temp |= 256; // 按位或 256 10 0000 0000 | 0000 0001 => 1 0000 0001

        String str = Integer.toBinaryString(temp);// 返回的是temp对应的二进制的补码
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    // 压缩
    public static byte[] huffmanZip(String str) {

        HuffmanNode root = createHuffmanTree(str);
        Map<Byte, String> codes = getCodes(root);
        byte[] zip = zip(str, codes);
        return zip;
    }


    // 进行压缩,将得到的字符串按照八个一位转换为byte数组
    public static byte[] zip(String str, Map<Byte, String> map) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        StringBuilder code = new StringBuilder();
        for (byte b : bytes) {
            code.append(map.get(b));
        }

        int len;
        if (code.length() % 8 == 0) {
            len = code.length() / 8;
        } else {
            len = code.length() / 8 + 1;
        }

        byte[] b = new byte[len];
        int index = 0;
        for (int i = 0; i < code.length(); i += 8) {
            String substring;
            if (i + 8 <= code.length()) {
                substring = code.substring(i, i + 8);
            } else {
                substring = code.substring(i);
            }

            byte n = (byte) Integer.parseInt(substring, 2);


            b[index] = n;
            index++;

        }

        return b;
    }


    // 用于存储编码集
    private static Map<Byte, String> huffmanCodes = new HashMap<>();
    private static StringBuilder stringBuilder = new StringBuilder();

    // 创建赫夫曼树对应的编码集
    public static Map<Byte, String> getCodes(HuffmanNode root) {
        if (root == null) {
            return null;
        }
        //处理 root 的左子树
        getCodes(root.getLeft(), "0", stringBuilder);
        //处理 root 的右子树
        getCodes(root.getRight(), "1", stringBuilder);

        return huffmanCodes;
    }

    private static void getCodes(HuffmanNode node, String s, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(s);
        if (node == null) {
            return;
        }
        if (node.getData() == null) {
            getCodes(node.getLeft(), "0", stringBuilder1);
            getCodes(node.getRight(), "1", stringBuilder1);
        } else {
            huffmanCodes.put(node.getData(), stringBuilder1.toString());
        }
    }


    /**
     * 创建一颗赫夫曼树
     *
     * @param str
     * @return
     */
    public static HuffmanNode createHuffmanTree(String str) {
        byte[] bytes = str.getBytes();
        List<HuffmanNode> nodes = getNodes(bytes);

        while (nodes.size() > 1) {
            Collections.sort(nodes);
            HuffmanNode node1 = nodes.remove(0);
            HuffmanNode node2 = nodes.remove(0);
            HuffmanNode root = new HuffmanNode(null, node1.getWeight() + node2.getWeight());
            root.setLeft(node1);
            root.setRight(node2);
            nodes.add(root);
        }

        return nodes.remove(0);
    }

    // 创建赫夫曼树所需要的节点
    public static List<HuffmanNode> getNodes(byte[] bytes) {
        List<HuffmanNode> list = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            Integer integer = map.get(b);
            if (integer == null) {
                map.put(b, 1);
            } else {
                map.put(b, integer + 1);
            }
        }
        for (Map.Entry<Byte, Integer> m : map.entrySet()) {
            list.add(new HuffmanNode(m.getKey(), m.getValue()));
        }
        return list;
    }

    // 遍历
    public static void Traversal(HuffmanNode root) {
        if (root == null) {
            System.out.println("这是一棵空树");
        } else {
            Order(root);
        }

    }

    private static void Order(HuffmanNode node) {

        if (node == null) {
            return;
        }
        System.out.println(node);
        HuffmanNode left = node.getLeft();
        if (left != null) {
            Order(left);
        }
        HuffmanNode right = node.getRight();
        if (right != null) {
            Order(right);
        }
    }

}
