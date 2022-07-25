package com.changing.huffmantree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author changing
 * @create 2021-08-27 12:35
 */
public class huffmantreeTest {

    public static void main(String[] args) {
        int[] arr = new int[]{13,7,8,3,29,6,1};

        huffmantree huffmantree = new huffmantree(arr);
        huffmantree.preOrder();

    }
}


class Node implements Comparable<Node>{
    private int weight;
    private Node left,right;


    public Node(int weight){
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

class huffmantree{
    private List<Node> nodes = new ArrayList<>();


    public huffmantree(int[] arr){
        for(int i : arr){
            nodes.add(new Node(i));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes);

            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(left.getWeight() + right.getWeight());
            parent.setLeft(left);
            parent.setRight(right);

            nodes.remove(left);
            nodes.remove(right);

            nodes.add(parent);
        }
    }

    public void preOrder(){
        if(nodes.get(0) == null){
            System.out.println("该赫夫曼数为空");
            return;
        }
        preOrder(nodes.get(0));
    }

    private void preOrder(Node node){
        if(node != null){
            System.out.println(node);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

}