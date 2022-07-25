package com.changing.recursion;

/**
 * @author changing
 * @create 2021-08-24 10:27
 */
public class Queue8 {
    static int max = 8;
    static int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queue(0);
        System.out.println(count);
    }


    //
    public static void Queue(int n){
        if(n == 8){
            print();
            count++;
        }else{
            for(int i = 0;i < max;i++){
                array[n] = i;
                if(judge(n)){
                    Queue(n + 1);
                }
            }
        }
    }

    //判断第n个皇后与前面的所有皇后是否冲突
    public static boolean judge(int n){
        for(int i = 0;i < n;i++){
            if(array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    //打印结果
    public static void print(){
        for(int i = 0;i < array.length;i++){
            System.out.print(array[i]);
        }
        System.out.println();
    }
}


