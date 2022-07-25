package com.changing.sort;

import com.changing.queue.ArrayQueueDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author changing
 * @create 2021-08-24 12:08
 */
public class SelectSort {
    public static void main(String[] args) {
        //int[] arr = new int[]{39,82,14,01,10,85,8};
        int[] arr1 = new int[80000];
        for (int i = 0;i < arr1.length;i++){
            arr1[i] = (int)(Math.random()*(82 + 1 - 14)) + 14;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = sdf.format(new Date());
        System.out.println(date1);
        selectSort(arr1);
        String date2 = sdf.format(new Date());
        System.out.println(date2);
        toString(arr1);

    }

    public static void selectSort(int[] arr){
        int min;
        for(int i = 0;i < arr.length - 1;i++){
            min = i;
            for(int j = i + 1;j < arr.length;j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            if(min != i){
                    int temp;
                    temp = arr[min];
                    arr[min] = arr[i];
                    arr[i] = temp;
            }
        }
    }

    public static void toString(int[] arr){
        for(int i : arr){
            System.out.print(i + "  ");
        }
    }
}
