package com.changing.queue;

import javax.swing.plaf.basic.BasicTreeUI;
import java.util.Scanner;

/**
 * 顺序队列
 * @author changing
 * @create 2021-08-19 18:23
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue aQ = new ArrayQueue(5);


        Scanner scan = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):取出数据");
            System.out.println("h(head):查看头数据");

            System.out.println("选择你要操作的功能");
            char key = scan.next().charAt(0);
            switch (key) {
                case 's':
                    aQ.showQueue();
                    break;
                case 'e':
                    if (scan == null) {
                        scan.close();
                    }
                    flag = false;
                    break;
                case 'a':
                    System.out.println("请输入您要添加的数据：");
                    aQ.addQueue(scan.nextInt());
                    break;
                case 'g':
                    try {
                        aQ.getQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int hQ = aQ.headQueue();
                        System.out.println("队列头数据为：" + hQ);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
        System.out.println("退出程序");
    }
}

    //数组模拟队列
    class ArrayQueue{
        private int maxSize;
        private int front;
        private int rear;
        private int[] arr;

        ArrayQueue(int maxsize){
            maxSize = maxsize;
            arr = new int[maxsize];
            front = -1;
            rear = -1;
        }
        //判断是否满了
         public boolean isFull(){
            if(rear == maxSize - 1){
                return true;
            }
            return false;
        }
        //判断是否为空
        public boolean isEmpty(){
            if(rear == front){
                return true;
            }
            return false;
        }

        // 添加数据到队列
        public void addQueue(int n){
            if(isFull()){
                System.out.println("该队列已满，不能加入数据");
            }else{
                rear++;
                arr[rear] = n;
            }
        }


        //获取队列中的数据，出队列
        public int getQueue(){
            if(isEmpty()){
                //通过抛出异常处理
                throw new RuntimeException("该队列为空，无数据可以出列");
            }else{
                front++;
                return arr[front];
            }
        }

        //显示队列所有数据
        public void showQueue(){
            if(isEmpty()){
                System.out.println("队列为空，没有数据");
            }else{
                for(int i = 0 ;i < arr.length;i++){
                    System.out.println("arr[" + i + "] = " + arr[i]);
                }
            }
        }

        //显示队列的头数据
        public int headQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空，无法显示头数据");
            }else{
                return arr[front + 1];
            }
        }

    }

