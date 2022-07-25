package com.changing.hashtab;

import java.awt.*;
import java.util.HashMap;
import java.util.logging.Level;

/**
 * @author changing
 * @create 2021-08-25 13:36
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(4);
        Emp emp1 = new Emp(1, "shaking");
        Emp emp2 = new Emp(3, "changing");
        Emp emp3 = new Emp(14, "懂帆");
        Emp emp4 = new Emp(4, "陈幸童");
        Emp emp5 = new Emp(82, "zsf");
        Emp emp6 = new Emp(809, "李梓萌");
        Emp emp7 = new Emp(27, "kun");
        hashTab.add(emp1);
        hashTab.add(emp2);
        hashTab.add(emp3);
        hashTab.add(emp4);
        hashTab.add(emp5);
        hashTab.add(emp6);
        hashTab.add(emp7);
        hashTab.findEmpById(14);


        hashTab.show();
    }
}

class HashTab{
    private EmpLinkedList[] empLinkedLists;
    private int length;
    public HashTab(int length){
        this.length = length;
        empLinkedLists = new EmpLinkedList[length];
        for(int i = 0;i < length;i++){
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        int i = hashFun(emp.getId());

        empLinkedLists[i].add(emp);

    }

    //显示哈希表表
    public void show(){
        for(int i = 0;i < length;i++){
            System.out.print("第" + (i + 1) + "条链表");
            empLinkedLists[i].show();
        }
    }

    //根据id查找员工
    public void findEmpById(int id){
        int i = hashFun(id);
        Emp empById = empLinkedLists[i].findEmpById(id);
        if(empById == null){
            System.out.println("未在哈希表中找到该员工");
        }else{
            System.out.println("该员工在哈希表中的第" + (i + 1) + "链表中，具体信息为：" + empById.toString());
        }
    }

    //散列函数
    private int hashFun(int id){
        return id % length;
    }
}

class Emp{
    private int id;
    private String name;
    public Emp next;

    public Emp(int id,String name){
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmpLinkedList{
    private Emp head;

    public Emp getHead() {
        return head;
    }

    public void setHead(Emp head) {
        this.head = head;
    }

    public void add(Emp emp){
        if(head == null){
            head = emp;
        }else{
            Emp p = head;//重点：只能通过.next赋值
            while (p.next != null){
                p = p.next;
            }
            p.next = emp;//重点：只能通过.next赋值
        }
    }

    //遍历链表
    public void show(){
        if(head == null){
            System.out.println("当前链表为空");
        }else{
            Emp p = head;
            while (p != null){
                System.out.print("\t=>\t" + p.toString());
                p = p.next;
            }
        }
        System.out.println();
    }

    //根据id查找雇员
    public Emp findEmpById(int id){

        if(head == null){
           return null;
        }else{
            Emp p = head;
            while (p != null){
                if(p.getId() == id){
                    return p;
                }
                p = p.next;
            }
        }
        return null;
    }
}
