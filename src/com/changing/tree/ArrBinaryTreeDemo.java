package com.changing.tree;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author changing
 * @create 2021-08-26 15:18
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();

    }
}
//编写一个ArrayBinaryTree,实现顺序存储二叉树遍历
class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }

    public void preOrder(){
        preOrder(0);
    }

    //编写一个方法，完成顺序存储二叉树的前序遍历
    private void preOrder(int i){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空，无法遍历");
            return;
        }

            System.out.println(arr[i]);
        if((2 * i + 1) < arr.length){
            preOrder(2 * i + 1);
        }
        if((2 * i + 2) < arr.length){

            preOrder(2 * i + 2);
        }
    }
}