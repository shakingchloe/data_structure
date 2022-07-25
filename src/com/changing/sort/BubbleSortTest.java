package com.changing.sort;

import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author changing
 * @create 2021-08-24 11:03
 */
public class BubbleSortTest {
    public static void main(String[] args) {
//        int[] arr = new int[]{5,14,98,3,4,89,89,82};
        int[] arr1 = new int[80000];
        //int radom = (int) (Math.random() * (82 + 1 - 14)) + 14;
        for(int i = 0;i < arr1.length;i++){
            arr1[i] = (int) (Math.random() * (82 + 1 - 14)) + 14;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = sdf.format(new Date());
        System.out.println(date1);
        BubbleSort.bubbleSort(arr1);
        String date2 = sdf.format(new Date());
        System.out.println(date2);
        BubbleSort.show(arr1);

//        int[] arrsort = BubbleSort.bubbleSort(arr);
//        System.out.println(BubbleSort.count);
//        BubbleSort.show(arr);

    }
}
