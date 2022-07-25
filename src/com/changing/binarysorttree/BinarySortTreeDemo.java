package com.changing.binarysorttree;

import java.awt.image.renderable.RenderableImage;
import java.util.Collection;
import java.util.function.IntToDoubleFunction;

/**
 * @author changing
 * @create 2021-08-28 18:14
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{7,3,10,12,5,1,9};

        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0;i < arr.length;i++){
            binarySortTree.add(new Node(arr[i]));
        }

        binarySortTree.inOrder();

        binarySortTree.del(new Node(100));
        binarySortTree.del(new Node(14));

        System.out.println("删除后的二叉顺序树");
        binarySortTree.inOrder();

    }


}

class BinarySortTree{
    private Node root;
    private int count;

    public BinarySortTree(){
        count = 0;
    }

    public void add(Node nodeAdd){
        if(root == null){
            root = nodeAdd;
        }else {
            addFun(root,nodeAdd);
        }
    }

    public void inOrder(){
        if(root == null){
            System.out.println("该二叉顺序树为空");
            return;
        }
        inOrder(root);
    }

    public Node del(Node nodeDel){
        if(root == null){
            System.out.println("删除失败，该二叉排序树为空");
            return null;
        }
        return del(root,nodeDel);
    }


    /*
    辅助函数
     */
    private void addFun(Node node,Node nodeAdd){
        if(node == null){
            return;
        }
        if(nodeAdd.getValue() < node.getValue()){
            if(node.getLeft() == null){
                node.setLeft(nodeAdd);
            }else {
                addFun(node.getLeft(),nodeAdd);
            }
        }else{
            if(node.getRight() == null){
                node.setRight(nodeAdd);
            }else {
                addFun(node.getRight(),nodeAdd);
            }
        }
    }




    //中序遍历
    private void inOrder(Node node){
        if(node != null){
            inOrder(node.getLeft());
            System.out.println(node);
            inOrder(node.getRight());
        }
    }

    //查找以node为根节点的最小节点，并返回最小节点
    public Node minimun(Node node){
        if(node.getLeft() == null){
            return node;
        }
        return minimun(node.getLeft());
    }

    //删除最小节点后返回根节点
    private Node removeMin(Node node){
        if(node.getLeft() == null){
            Node rightNode = node.getRight();
            node.setRight(null);
            count--;
            return rightNode;
        }
        node.setLeft(removeMin(node.getLeft()));
        return node;
    }

   //删除节点
    private Node del(Node node,Node nodeDel){
        if(node == null){
            return null;
        }

        if(nodeDel.getValue() < node.getValue()){
            node.setLeft(del(node.getLeft(),nodeDel));
            return node;
        }else if(nodeDel.getValue() > node.getValue()) {
            node.setRight(del(node.getRight(),nodeDel));
            return node;
        }else{//找到删除节点
            if(node.getRight() == null){
               Node leftNode = node.getLeft();
               node.setLeft(null);
                count--;
               return leftNode;
            }else if(node.getLeft() == null){
                Node rightNode = node.getRight();
                node.setRight(null);
                count--;
                return rightNode;
            }else{
                Node minimun = minimun(node.getRight());
                minimun.setRight(removeMin(node.getRight()));
                count++;
                minimun.setLeft(node.getLeft());

                node.setLeft(null);
                node.setRight(null);
                count--;
                return minimun;
            }
        }
    }
}

class Node{
    private int value;
    private Node left;
    private Node right;

    public Node(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
                "value=" + value +
                '}';
    }

}
