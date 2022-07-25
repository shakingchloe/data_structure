package com.changing.graph;

import com.changing.recursion.Queue8;

import java.util.*;

/**
 * @author changing
 * @create 2021-08-29 16:47
 */
public class GraphTest {


    public static void main(String[] args) {

        int n = 8;
        String Vertexes[] = {"0","1","2","3","4","5","6","7"};
        Graph graph = new Graph(n);
        for(String vertex : Vertexes){
            graph.insertVertex(vertex);
        }
        //添加边
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.insertEdge(2,5,1);
        graph.insertEdge(2,6,1);
        graph.insertEdge(3,7,1);
        graph.insertEdge(4,7,1);
        graph.insertEdge(5,6,1);

        //graph.showGraph();
        //graph.DFS();
        graph.BFS(0);
    }
}

class Graph{
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;
    private LinkedList<Integer> list = new LinkedList<>();

    public Graph(int n){
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //广度优先遍历
    public void BFS(int v){
        isVisited[v] = true;

        list.add(v);
        while (list.size() != 0){
            System.out.print(vertexList.get(list.getFirst()));

            for(int i = 0;i < edges[list.getFirst()].length;i++){
                if(!isVisited[i] && edges[list.getFirst()][i] != 0){
                    isVisited[i] = true;
                    list.add(i);
                }
            }
            list.removeFirst();
        }

    }

    //深度优先遍历
    public void DFS(){
        for(int i = 0;i < isVisited.length;i++){
            if(!isVisited[i]){
                DFS(i);
                System.out.println();
            }
        }
    }

    //返回结点个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //返回边数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //返回结点i(下标)对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //显示图对应的矩阵
    public void showGraph(){
        for(int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }

    //插入结点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //添加边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //深度优先遍历
    private void DFS(int v){
        System.out.print(vertexList.get(v) + "->");
        isVisited[v] = true;
        for(int i = 0;i < vertexList.size();i++){
            if(edges[v][i] != 0 && (!isVisited[i])){
                DFS(i);
            }
        }
    }
}

