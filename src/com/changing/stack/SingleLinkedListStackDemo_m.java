package com.changing.stack;

import java.util.Scanner;

/**
 * @author changing
 * @create 2021-08-22 20:44
 */
public class SingleLinkedListStackDemo_m {
    public static void main(String[] args) {
        SingleLinkedListStack stack = new SingleLinkedListStack();

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

                    stack.push(new PersonNode(scan.nextInt()));
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "exit":
                    System.out.println("退出成功");
                     return;
            }
        }
    }
}

class SingleLinkedListStack{
    private PersonNode top = new PersonNode(-1);

    //判断是否是空
    public boolean isEmpty(){
        return top.getNext() == null;
    }

    //入栈
    public void push(PersonNode personNode){
        if(top.getNext() == null){
            top.setNext(personNode);
            System.out.println("添加成功");
            return;
        }
        PersonNode p = top.getNext();
        top.setNext(personNode);
        personNode.setNext(p);
        System.out.println("添加成功");
    }

    //出栈
    public void pop(){
        if(top.getNext() == null){
            System.out.println("栈空");
        }
        System.out.println("出栈节点为：" + top.getNext());
        top = top.getNext();
    }

    //遍历
    public void list(){
        if(top.getNext() == null){
            System.out.println("空栈");
            return;
        }
        PersonNode p = top.getNext();
        while (p != null){
            System.out.println("节点" + p);
            p = p.getNext();
        }
    }
}

class PersonNode{
    private int val;
    private PersonNode next;

    public PersonNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public PersonNode getNext() {
        return next;
    }

    public void setNext(PersonNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "PersonNode{" +
                "val=" + val +
                '}';
    }
}