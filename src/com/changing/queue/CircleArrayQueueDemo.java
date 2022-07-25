package com.changing.queue;

import java.util.Scanner;

/**
 * 循环队列
 * @author changing
 * @create 2021-08-20 13:54
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray carr = new CircleArray(5);


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
                    carr.showQueue();
                    break;
                case 'e':
                    if (scan == null) {
                        scan.close();
                    }
                    flag = false;
                    break;
                case 'a':
                    System.out.println("请输入您要添加的数据：");
                    carr.addQueue(scan.nextInt());
                    break;
                case 'g':
                    try {
                        carr.getQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int hQ = carr.headQueue();
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

class CircleArray{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int maxsize){
        maxSize = maxsize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否满
    public boolean isFull(){

        return (rear + 1) % maxSize == front;
    }

    //判断是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("该队列已满，不能加入数据");
        }else{
            arr[rear] = n;
           rear = (rear + 1) % maxSize;
        }
    }


    //获取队列中的数据，出队列
    public int getQueue(){
        if(isEmpty()){
            //通过抛出异常处理
            throw new RuntimeException("该队列为空，无数据可以出列");
        }else{
            int val = arr[front];
            front = (front + 1) % maxSize;
            return val;
        }
    }

    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
        }else{
            for(int i = front ;i < front + size();i++){
                System.out.println("arr[" + i % maxSize + "] = " + arr[i % maxSize]);
            }
        }
    }

    //显示队列的头数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法显示头数据");
        }else{
            return arr[front];
        }
    }


}
