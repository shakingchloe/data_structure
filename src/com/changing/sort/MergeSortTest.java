package com.changing.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author changing
 * @create 2021-08-30 11:16
 */
public class MergeSortTest {
    public static void main(String[] args) {

//        //int[] arr = new int[]{8,4,5,7,1,3,6,2};
//        int[] arr1 = new int[8000000];
//        //int radom = (int) (Math.random() * (82 + 1 - 14)) + 14;
//        for(int i = 0;i < arr1.length;i++){
//            arr1[i] = (int) (Math.random() * (82 + 1 - 14)) + 14;
//        }
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1 = sdf.format(new Date());
//        System.out.println(date1);
//        System.out.println("a");
//        int[] sort = MergeSort.sort(arr1);
//        //System.out.println(Arrays.toString(sort));
//        String date2 = sdf.format(new Date());
//        System.out.println(date2);
//
////        int[] sort = MergeSort.sort(arr);
////        System.out.println(Arrays.toString(sort));

        int[] arr = {2,5,3,1,55,3};
//        int[] sort = insertionSort(arr);
        int[] sort = MergeSort.sort(arr);
        System.out.println(Arrays.toString(sort));
    }

}

class MergeSort{

    public static int[] sort(int[] sourceArray){

        int[] arr= Arrays.copyOf(sourceArray,sourceArray.length);

        if(arr.length < 2 ){
            return arr;
        }
        int middle = (int)Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr,0,middle);
        int[] right = Arrays.copyOfRange(arr,middle,arr.length);

        return merge(sort(left),sort(right));
    }

    private static int[] merge(int[] left,int[] right){
        int[] result = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length){
            if(left[i] <= right[j]){
                result[k] = left[i];
                i++;
                k++;
            }else {
                result[k] = right[j];
                j++;
                k++;
            }
        }
        while (i < left.length){
            result[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length){
            result[k] = right[j];
            j++;
            k++;
        }
        return result;
    }
}
