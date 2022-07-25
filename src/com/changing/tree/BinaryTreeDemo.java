package com.changing.tree;

import org.w3c.dom.Node;

/**
 * @author changing
 * @create 2021-08-25 20:50
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.Node root = new BinaryTree.Node(1, "shaking");
        BinaryTree.Node node2 = new BinaryTree.Node(2, "changing");
        BinaryTree.Node node3 = new BinaryTree.Node(3, "陈幸童");
        BinaryTree.Node node4 = new BinaryTree.Node(4, "zsf");
        BinaryTree.Node node5 = new BinaryTree.Node(5, "kun");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);
        System.out.println("前序遍历");
        binaryTree.preOrder();
        binaryTree.del(3);
        System.out.println("删除后的二叉树");
        binaryTree.preOrder();

//        System.out.println("中序遍历");
//        binaryTree.inOrder();
//
//        System.out.println("后序遍历");
//        binaryTree.postOrder();

//        BinaryTree.Node nodeF1 = binaryTree.preFind(4);
//        System.out.println(nodeF1);

//        BinaryTree.Node nodeF2 = binaryTree.postFind(5);
//
//        System.out.println(binaryTree.getFcount());
//        System.out.println(nodeF2);

//        BinaryTree.Node nodeF3 = null;
//        try {
//            nodeF3 = binaryTree.preFind( 15);
//            System.out.println(nodeF3);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());;
//        }

    }
}


class BinaryTree{
    public static class Node{
        private int id;
        private String name;
        private Node left;
        private Node right;


        public Node(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private Node root;
    private int count;
    private int Fcount;

    public BinaryTree(){
        count = 0;
        Fcount = 0;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFcount() {
        return Fcount;
    }


    //判断是否为空二叉树
    public boolean isEmpty(){
        return root == null;
    }

    public void preOrder(){
        if(root == null){
            System.out.println("该二叉树为空");
        }else{
            preOrder(root);
        }
    }

    public void inOrder(){
        if(root == null){
            System.out.println("该二叉树为空");
        }else{
            inOrder(root);
        }
    }

    public void postOrder(){
        if(root == null){
            System.out.println("该二叉树为空");
        }else{
            postOrder(root);
        }
    }

    public Node preFind(int id){
        if(root == null){
            System.out.println("该二叉树为空");
            return null;
        }
        Node temp;
        if((temp = preFind(root,id)) == null){
            throw new RuntimeException("未找到该节点");
        }else {
            return  temp;
        }
    }

    public Node inFind(int id){
        if(root == null){
            System.out.println("该二叉树为空");
            return null;
        }
        Node temp;
        if((temp = inFind(root,id)) == null){
            throw new RuntimeException("未找到该节点");
        }else {
            return  temp;
        }
    }

    public Node postFind(int id){
        if(root == null){
            System.out.println("该二叉树为空");
            return null;
        }
        Node temp;
        if((temp = postFind(root,id)) == null){
            throw new RuntimeException("未找到该节点");
        }else {
            return  temp;
        }
    }

    //删除节点
    public void del(int id){
        if(root == null){
            System.out.println("该二叉树为空");
            return;
        }
        if(root.id == id){
            root = null;
            return;
        }
        if(del(root,id) == false){
            System.out.println("删除失败，未在二叉树中找到数据");
        }

    }

    /*
    辅助函数
     */
    //前序遍历
    private void preOrder(Node node){
        if(node != null){
            System.out.println(node);
            preOrder(node.left);
            preOrder(node.right);
        }

    }

    //中序遍历
    private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node);
            inOrder(node.right);
        }
    }

    //后序遍历
    private void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node);
        }
    }

    //前序查找
    private Node preFind(Node node,int id){
        if(node == null) {
            return null;
        }
            Fcount++;
            if (node.id == id) {

                return node;
            } else {
                Node temp;
                if ((temp = preFind(node.left, id)) != null) {
                    return temp;
                } else {
                    return preFind(node.right, id);
                }
            }


    }

    //中序遍历查找
    private Node inFind(Node node,int id){
        if(node == null){
            return null;
        }

        Node temp;
        if((temp = inFind(node.left,id)) != null){
            return temp;
        }else{
            Fcount++;
            if(node.id == id){
                return node;
            }else{
                return inFind(node.right,id);
            }
        }
    }

    //后序遍历查找
    private Node postFind(Node node,int id){

        if(node == null){
            return null;
        }
        Node temp;
        if((temp = postFind(node.left,id)) != null){
            return temp;
        }else{
            if((temp = postFind(node.right,id)) != null){
                return temp;
            }else{
                System.out.println("shaking");
                Fcount++;
                if(node.id == id){
                    return node;
                }else{
                    return null;
                }
            }
        }
    }

    //删除节点
    private boolean del(Node node,int id){
        if(node.left == null && node.right == null){
            return false;
        }
        if(node.left != null && node.left.id == id){
            node.left = null;
            return true;
        }else if(node.right != null && node.right.id == id){
            node.right = null;
            return true;
        }else{
            if(del(node.left,id)){
                return true;
            }else {
               return del(node.right,id);
            }
        }
    }
}