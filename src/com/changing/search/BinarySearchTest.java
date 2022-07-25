package com.changing.search;

import java.security.PrivateKey;
import java.util.ArrayList;

/**
 * @author changing
 * @create 2021-08-30 22:56
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1,34,34,34,34,34,82,109,119,120,130,209,298};
        ArrayList<Integer> i = BinarySearch.sort1(arr,34,0,arr.length - 1);
        System.out.println(i);
    }
}

class BinarySearch{
    //非递归
    public static int sort(int[] arr,int value){
        int low = 0;
        int hight = arr.length - 1;
        while (low <= hight){
            int mid = (low + hight) / 2;
            if(arr[mid] == value){
                return mid;
            }else if(value < arr[mid]){
                hight = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
    //递归
    public static ArrayList<Integer> sort1(int[] arr,int value,int low,int hight){
        ArrayList<Integer> list = new ArrayList<>();
        int mid = (low + hight) / 2;
        while (low <= hight){
            if(arr[mid] == value){
                list.add(mid);
                int temp = mid;
                while (temp > low && arr[--temp] == value){
                    list.add(temp);
                }
                temp = mid;
                while (temp < hight && arr[++temp] == value ){
                    list.add(temp);
                }
                return list;
            }else if(value < arr[mid]){
                return sort1(arr,value,low,mid - 1);
            }else {
                return sort1(arr,value,mid + 1,hight);
            }
        }
        return list;
    }
}
