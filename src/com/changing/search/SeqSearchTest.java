package com.changing.search;

/**
 * @author changing
 * @create 2021-08-30 20:34
 */
public class SeqSearchTest {
    public static void main(String[] args) {
        int[] arr = new int[]{38,239,14,82,41};
        int searchIndex = SeqSearch.search(arr, 182);
        System.out.println(searchIndex);
    }
}

class SeqSearch{
    public static int search(int[] arr,int value){
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
