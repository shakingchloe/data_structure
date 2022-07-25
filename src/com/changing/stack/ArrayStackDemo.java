package com.changing.stack;

import java.util.Scanner;

/**
 * @author changing
 * @create 2021-08-22 17:21
 */
public class ArrayStackDemo {

    public static void main(String[] args){
        ArrayStack stack = new ArrayStack(4);

        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("show:显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:入栈");
            System.out.println("pop:出栈");
            System.out.println("请选择你要操作的功能");
            switch (scan.next()){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入您的数据：");
                    stack.push(scan.nextInt());
                    break;
                case "pop":
                    try {
                        int poval = stack.pop();
                        System.out.println("出栈的数据为：" + poval);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    System.out.println("退出成功");
                    return;
            }
        }
    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int val){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = val;
    }

    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //遍历栈
    public void list(){
        if(isEmpty()){
            System.out.println("栈空");
        }
        for(int i = top;i >= 0;i--){
            System.out.println("stack[" + i + "] = " + stack[i]);
        }
    }
}
