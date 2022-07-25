package com.changing.avl;

/**
 * @author changing
 * @create 2021-08-29 0:07
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
//        int[] arr = new int[]{4,3,6,5,7,8};
        int[] arr = new int[]{10,11,7,6,8,9};
        AVLTree avlTree = new AVLTree();
        for(int i = 0;i < arr.length;i++){
            avlTree.add(new Node(arr[i]));
        }

        System.out.println("中序遍历");
        avlTree.inOrder();

        System.out.println("平衡二叉树");
        System.out.println("树的高度 = " + avlTree.getRoot().height());
        System.out.println("树的左子树高度 = " + avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度 = " + avlTree.getRoot().rightHeight());
        System.out.println("当前的根结点 = " + avlTree.getRoot());
        System.out.println("根结点的左子结点 + " + avlTree.getRoot().getLeft());
        System.out.println("根结点的左子结点的左子结点 + " + avlTree.getRoot().getLeft().getLeft());
        System.out.println("根结点的左子结点的左子结点 + " + avlTree.getRoot().getLeft().getLeft());
        System.out.println(avlTree.getRoot().getRight().getLeft());
    }
}


class AVLTree{
    private Node root;
    private int count;

    public AVLTree(){
        count = 0;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
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
    //插入新的数据
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
        //R型
        //（右子树的高度 - 左子树的高度 ）> 1
        if(node.rightHeight() - node.leftHeight() > 1){
            if(node.getRight().leftHeight() > node.getRight().rightHeight()){
                node.rlRotate();
            }else {
                node.rrRotate();
            }
            return;
        }

        //L型
        if(node.leftHeight() - node.rightHeight() > 1){
            if(node.getLeft().rightHeight() > node.getLeft().leftHeight()){
                node.lrRotate();
            }else {
                node.llRotate();
            }
            return;
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

    //右子树的高度
    public int leftHeight(){
        if(left == null){
            return 0;
        }
        return left.height();
    }

    //左子树的高度
    public int rightHeight(){
        if(right == null){
            return 0;
        }
        return right.height();
    }

    //返回以该节点为根的树的高度
    public int height(){
        return Math.max(left == null ? 0 : left.height(),right == null ? 0 : right.height()) + 1;
    }

    //RR型旋转
    public void rrRotate(){

        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        right = right.right;
        left = newNode;

    }

    //RL型旋转
    public void rlRotate(){
        right.llRotate();
        rrRotate();
    }

    //LL型旋转
    public void llRotate(){
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    //LR型旋转
    public void lrRotate(){
        left.rrRotate();
        llRotate();
    }

    public int getValue() {
        return value;
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
