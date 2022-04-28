package data_structure.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 刘佳俊
 */
public class Graph {
    private ArrayList<String> vertexList; //存储顶点的集合
    private int[][] edges; // 存储图对应的邻接矩阵
    private int numOfEdges; // 表示边的数目
    private boolean[] flag; // 表示某个顶点是否被访问过,通过下标一一对应

    public static void main(String[] args) {
        // 节点个数
        int n = 5;

        String vertexs[] = {"A", "B", "C", "D", "E"};
        // 创建图对象
        Graph graph = new Graph(n);
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }
        // 添加边
        graph.insertEdge(0, 4, 1);
        graph.insertEdge(4, 3, 1);
        graph.insertEdge(4, 2, 1);

        graph.insertEdge(2, 1, 1);
        graph.showGraph();
        graph.dfs2(0);

    }


    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        flag = new boolean[n];
        numOfEdges = 0;
    }

    private int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    // 根据前一个邻接顶点的下标获取下一个邻接顶点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    private void dfs(int i) {
        //首先我们访问该结点,输出
        System.out.print(getValueByIndex(i) + "->");
        flag[i] = true;
        //查找结点 i 的第一个邻接结点 w
        int w = getFirstNeighbor(i);
        while (w != -1) {
            //说明有
            if (!flag[w]) {
                dfs(w);
            }
            //如果 w 结点已经被访问过,对比我自己实现的方法,这里传入的是
            w = getNextNeighbor(i, w);
        }
    }


    // 自己实现的
    public void dfs2(int index) {
        if (!flag[index]) {
            System.out.print(getValueByIndex(index) + "->");
            flag[index] = true;
        }
        // 对于一个顶点第一次查找邻接顶点,是从0开始的
        int w = getNeighbor(index,0);
        while (w != -1) {
            dfs2(w);
            // 注意这里我们任然将正在遍历的顶点的index传入,因为我们需要遍历剩下的邻接顶点,这里的w是查找邻接顶点的开始坐标,
            w = getNeighbor(index,w);
        }
    }

    public int getNeighbor(int index,int begin) {
        for (int i = begin+1; i < vertexList.size(); i++) {
            if (edges[index][i] > 0 && flag[i] == false) {
                return i;
            }

        }

        return -1;
    }

    // 图中常用的方法

    // 显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    // 返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    // 得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    // 返回节点i(下标)对应的值
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    // 返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    // 插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    // 添加边
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }


}



