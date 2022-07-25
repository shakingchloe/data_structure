package com.changing.sort;

import javax.crypto.interfaces.PBEKey;
import javax.swing.text.FlowView;

/**
 * @author changing
 * @create 2021-08-24 10:55
 */
class BubbleSort {
    static int count = 0;
    public  static int[] bubbleSort(int[] arr){
        boolean flag = false;
        for(int i = 0;i < arr.length - 1;i++){
            count++;
            for(int j = 0;j < arr.length - 1 -i;j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }else {
                flag = false;
            }
        }
        return arr;
    }

    public  static void show(int[] arr){
        System.out.print("arr = [");
        for(int i : arr){
            System.out.print(i + "  ");
        }
        System.out.print("]");
    }
}
