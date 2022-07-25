package com.changing.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author changing
 * @create 2021-08-24 14:04
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{39,82,14,01,10,85,8,65};
        int[] arr1 = new int[80000];
        for (int i = 0;i < arr1.length;i++){
            arr1[i] = (int)(Math.random()*(82 + 1 - 14)) + 14;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = sdf.format(new Date());
        System.out.println(date1);
        insertSort(arr1);
        String date2 = sdf.format(new Date());
        System.out.println(date2);
        toString(arr1);
        insertSort(arr1);
        toString(arr1);
    }

    public static void insertSort(int[] arr){
        for(int i = 1;i < arr.length;i++){
            int temp = arr[i];
            int j = i;
            while(j > 0 && temp < arr[j -1]){
                arr[j] = arr[j - 1];
                j--;
            }
            if(j != i){
                arr[j] = temp;
            }
        }
    }
    public static void toString(int[] arr){
        for(int i : arr){
            System.out.print(i + "  ");
        }
    }
}
