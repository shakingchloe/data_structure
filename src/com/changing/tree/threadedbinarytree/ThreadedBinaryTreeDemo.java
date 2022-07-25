package com.changing.tree.threadedbinarytree;



/**
 * @author changing
 * @create 2021-08-26 15:54
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        ThreadedBinaryTree.Node root = new ThreadedBinaryTree.Node(1, "shaking");
        ThreadedBinaryTree.Node node2 = new ThreadedBinaryTree.Node(3, "changing");
        ThreadedBinaryTree.Node node3 = new ThreadedBinaryTree.Node(6, "陈幸童");
        ThreadedBinaryTree.Node node4 = new ThreadedBinaryTree.Node(8, "zsf");
        ThreadedBinaryTree.Node node5 = new ThreadedBinaryTree.Node(10, "kun");
        ThreadedBinaryTree.Node node6 = new ThreadedBinaryTree.Node(14, "kun");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadeNodes();

        ThreadedBinaryTree.Node left = node5.getLeft();
        ThreadedBinaryTree.Node right = node5.getRight();
        System.out.println(left);
        System.out.println(right);

        threadedBinaryTree.inOrder();

    }
}
class  ThreadedBinaryTree {
    public static class Node {
        private int id;
        private String name;
        private Node left;
        private Node right;

        private int leftType;
        private int rightType;

        public int getLeftType() {
            return leftType;
        }

        public void setLeftType(int leftType) {
            this.leftType = leftType;
        }

        public int getRightType() {
            return rightType;
        }

        public void setRightType(int rightType) {
            this.rightType = rightType;
        }



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
    private Node pre;


    public void setFcount(int fcount) {
        Fcount = fcount;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }



    public ThreadedBinaryTree() {
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

    public void threadeNodes(){
        threadedNodes(root);
    }

    //编写对二叉树进行中序线索化的方法
    private void threadedNodes(Node node){
        if(node == null){
            return;
        }

        threadedNodes(node.left);

        if(node.left == null){
            node.left = pre;
            node.leftType = 1;
        }

        //将上一个节点的右节点指向自己
        if(pre != null && pre.right == null){
            pre.right = node;
            pre.rightType = 1;
        }

        pre = node;

         threadedNodes(node.right);
    }

    public void inOrder(){
        Node node = root;
        while(node != null){
            while(node.leftType == 0){
                node = node.left;
            }

            System.out.println(node);

            while(node.rightType == 1){
                node = node.right;
                System.out.println(node);
            }

            node = node.right;
        }
    }


}
