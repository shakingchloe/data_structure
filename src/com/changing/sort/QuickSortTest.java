package com.changing.sort;

import java.util.Arrays;

/**
 * @author changing
 * @create 2021-08-30 17:48
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{-9,-8,-16,-1116,-2116,-236762,9,98,978,2,348,3};
        int[] sort = QuickSort.sort(arr);
        System.out.println(Arrays.toString(sort));
    }
}

class QuickSort{
    public static int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        return quickSort(arr,0,arr.length - 1);
    }

    private static int[] quickSort(int[] arr,int left,int right){
        if(left < right){
            int partitionIndex = partition(arr, left, right);
            quickSort(arr,left,partitionIndex - 1);
            quickSort(arr,partitionIndex + 1,right);
        }

        return arr;
    }


    private static int partition(int[] arr,int left,int right){
        //设定基准值
        int pivot = left;
        int index = pivot + 1;
        for(int i = index;i <= right;i++){
            if(arr[i] < arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,pivot,index - 1);
        return index - 1;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
