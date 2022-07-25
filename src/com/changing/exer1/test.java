package com.changing.exer1;

/**
 * @author changing
 * @create 2021-08-21 13:28
 */
public class test{
    public static void main(String[] args) {
        Person p1 = new Person(1,"shaking");
        Person p2 = new Person(2,"changing");
        Person p3 = new Person(3,"kun");
        Person p4 = new Person(4,"zsf");

        CircleSingleLinkedList csl = new CircleSingleLinkedList();
        csl.add(p1);
        csl.add(p2);
        csl.add(p3);
        csl.add(p4);
//        csl.del(7);
//        System.out.println(csl.getCount());
        csl.list();
//        Person delp = csl.del(3);
//
//        System.out.println("删除后的链表");
//        csl.list();
//        System.out.println(csl.getCount());

        System.out.println("重新排序后：");
        fun(csl,2).list();



    }

    public static CircleSingleLinkedList fun(CircleSingleLinkedList csl,int k){
        CircleSingleLinkedList csl1 = new CircleSingleLinkedList();
        Person p = csl.getHead().next;
        while(csl.getCount() != 0){
            for(int j = 1;j < k + 1;j++){
                if(j % k == 0){
                    Person p2 = p.next;
                    csl.del(p.no);
                    System.out.println("---");
                    csl.list();
                    csl1.add(p);
                    System.out.println("---");
                    csl1.list();
                    p = p2;
                    break;
                }
                p = p.next;
            }
        }
        return csl1;
    }

}

class CircleSingleLinkedList{
    private int count = 0;
    private Person head = new Person(0,"");
    private Person c= head;

    public int getCount(){
        return count;
    }
    public Person getHead(){
        return head;
    }
    //添加数据
    public void add(Person person){

        c.next = person;
        person.next = head.next;
        c = c.next;
        count++;

    }

    //取出数据
    public Person del(int no){
        if(head.next == null){
            System.out.println("链表为空");
            return null;
        }

        if(count == 1){
            Person p2 = head.next;
            count--;
            c = head;
            head.next = null;
            return p2;
        }
        if(head.next.no == no){
            Person p2 = head.next;
            c.next = head.next.next;
            head.next = head.next.next;
            count--;
            return p2;
        }
        Person p = head.next;
        while(p.next != head.next){
            if(p.next.no == no){
                if(p.next == c){
                    c = p;
                }
                Person p2 = p.next;
                p.next = p.next.next;
                count--;
                return p2;
            }
            p = p.next;
        }
        System.out.println("未找到该数据");
        return null;
    }

    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        Person p = head.next;
        System.out.println(p);
        p = p.next;
        while (p != head.next){
            System.out.println(p);
            p = p.next;
        }
    }
}

class Person{
    public int no;
    private String name;
    public Person next;

    Person(int no,String name){
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}