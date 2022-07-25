package com.changing.linkedlist;

import java.awt.print.PrinterJob;

/**
 * @author changing
 * @create 2021-08-21 19:13
 */
public class DoubleLinkedDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1,"谢可寅","Shaking");
        HeroNode2 hero2 = new HeroNode2(2,"郑少芬","盛夏");
        HeroNode2 hero3 = new HeroNode2(3,"许馨文","新闻");
        HeroNode2 hero4 = new HeroNode2(4,"蔡徐坤","Kun");
        HeroNode2 hero5 = new HeroNode2(5,"陈幸童","tong");
        HeroNode2 hero6 = new HeroNode2(6,"懂帆","fan");
        HeroNode2 hero7 = new HeroNode2(7,"虎丝","小老虎");

        DoubleLinkedList dl = new DoubleLinkedList();
        dl.addByOrder(hero1);
        dl.addByOrder(hero3);
        dl.addByOrder(hero2);
        dl.addByOrder(hero5);
        dl.addByOrder(hero1);

        System.out.println("第一次初始化的链表：");
        dl.list();

//        dl.update(hero6);
//        System.out.println("修改后的链表：");
//        dl.list();

//        dl.del(4);
//        System.out.println("删除数据后的链表：");
//        dl.list();


    }
}

class DoubleLinkedList{

    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead(){
        return  head;
    }

    //遍历双向链表
    public void list(){
        HeroNode2 p = head;
        while(p.next != null){
            System.out.println(p.next);
            p = p.next;
        }
    }

    //添加数据
    public void add(HeroNode2 heroNode){
        HeroNode2 p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = heroNode;
        heroNode.pre = p;
    }

    //修改链表中的数据
    public void update(HeroNode2 heronode){
        if(head.next == null){
            System.out.println("链表为空，无数据修改");
        }
        HeroNode2 p = head.next;
        while (p != null){
            if(p.no == heronode.no){
                p.pre.next = heronode;
                heronode.next = p.next;
                return;
            }
            p = p.next;
        }
        System.out.println("未找到该数据");
    }

    //删除数据
    public void del(int no){
        if(head.next == null){
            System.out.println("链表为空，无数据修改");
        }
        HeroNode2 p = head.next;
        while (p != null){
            if(p.no == no){
                p.pre.next = p.next;
                if(p.next != null){
                    p.next.pre = p.pre;
                }
                return;
            }
            p = p.next;
        }
        System.out.println("未找到该数据");
    }

    //按照编号添加数据
    public void addByOrder(HeroNode2 heroNode){
        HeroNode2 p = head;
//        boolean flag = true;
        while(p.next != null){
            if(p.next.no > heroNode.no){
                heroNode.next = p.next;
                p.next.pre = heroNode;
                p.next = heroNode;
                heroNode.pre = p;
                return;
            }else if(p.next.no == heroNode.no){
                System.out.println("该数据已存在");
                return;
            }
            p = p.next;
        }
       p.next = heroNode;
        heroNode.pre = p;
    }
}


class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 pre;
    public HeroNode2 next;

    public HeroNode2(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}