package com.changing.tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author changing
 * @create 2021-08-26 21:37
 */
public class HeapSort {

    public static void main(String[] args) {
//       int[] arr = new int[]{4,60,8,5,9};
        int[] arr1 = new int[800000000];
        for (int i = 0;i < arr1.length;i++){
            arr1[i] = (int)(Math.random()*(82 + 1 - 14)) + 14;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = sdf.format(new Date());
        System.out.println(date1);
        heapSort(arr1);
        String date2 = sdf.format(new Date());
        System.out.println(date2);
        //System.out.println(Arrays.toString(arr1));
    }

    //编写一个堆排序的方法
    public static void heapSort(int[] arr){
        for(int i = arr.length / 2;i >= 0;i--){
            adjustHeap(arr,i,arr.length);
        }

        for(int j = arr.length - 1;j > 0;j--){
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
    }

    //将一个数组（二叉树），调整成一个顶堆
    public static void adjustHeap(int[] arr,int i,int length){
        //
         for(int k = i * 2 + 1;k < length;k = k * 2 + 1){

             if(k + 1 < length && arr[k + 1] > arr[k]){
                 k++;
             }
             if(arr[i] < arr[k]){
                 int temp = arr[i];
                 arr[i] = arr[k];
                 arr[k] = temp;
                 i = k;
             }
         }
    }

}


