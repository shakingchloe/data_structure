package com.changing.sort;

import java.util.Arrays;

/**
 * @author changing
 * @create 2021-08-24 16:20
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{39,82,14,01,10,85,8,65};
        System.out.println(Arrays.toString(arr));

        int[] arrsort = shellShort(arr);
        System.out.println(Arrays.toString(arrsort));
    }

    public static int[] shellShort(int[] arr){
        for(int step = arr.length/2;step > 0;step /= 2){
            for(int i = step;i >= 0 && i < arr.length;i++){
                int temp = arr[i];
                int j = i;
                while((j - step) >= 0 && temp < arr[j - step]){
                    arr[j] = arr[j - step];
                    j -= step;
                }
                if(j != i){
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}


