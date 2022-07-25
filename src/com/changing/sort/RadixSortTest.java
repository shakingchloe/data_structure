package com.changing.sort;

import java.util.Arrays;

/**
 * @author changing
 * @create 2021-08-30 13:57
 */
public class RadixSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{-9,-8,-16,-1116,-2116,-236762,9,98,978,2,348,3};
        //System.out.println(RadixSort.test(arr));
        System.out.println("git");
        int[] sort = RadixSort.sort(arr);
        System.out.println(Arrays.toString(sort));
    }
}

//正负数都可排序
class RadixSort{

    //
    public static int[] sort(int[] arr){


        for(int i =0,mod = 10,dev = 1;i < getMaxLength(arr);i++,mod *= 10,dev *= 10){
            int[][] tempArr = new int[20][0];
            for(int j = 0;j < arr.length;j++){
                int bucket;
                if(arr[j] < 0){
                    bucket = (arr[j] % mod) / dev + 10 - 1;
                }else {
                    bucket = (arr[j] % mod) / dev + 10;
                }

                tempArr[bucket] = arrayAppend(tempArr[bucket],arr[j]);
            }

            int pos = 0;
            for(int[] temp : tempArr){
                for(int n : temp){
                    arr[pos++] = n;
                }
            }
        }
        return arr;
    }

    public static int test(int[] arr){
        return getMaxLength(arr);
    }
    //返回数组中的最高位数
    private static int getMaxLength(int[] arr){
        int length = 0;
        int maxValue = getMaxValue(arr);
        if(maxValue == 0){
            return 1;
        }

        while (maxValue != 0){
            length++;
            maxValue /= 10;
        }
        return length;
    }

    //返回最大值
    private static int getMaxValue(int[] arr){
        int maxValue = Math.abs(arr[0]);
        for(int i : arr){
            if(Math.abs(i) > Math.abs(maxValue)){
                maxValue = Math.abs(i);
            }
        }
        return maxValue;
    }

    //扩容数组
    private static int[] arrayAppend(int[] arr,int value){
        int[] arr1 = Arrays.copyOf(arr,arr.length + 1);
        arr1[arr1.length - 1] = value;
        return arr1;
    }
}
