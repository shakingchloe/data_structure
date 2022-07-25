package com.changing.linkedlist;

/**
 * 单链表
 * @author changing
 * @create 2021-08-20 15:54
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"谢可寅","Shaking");
        HeroNode hero2 = new HeroNode(2,"郑少芬","盛夏");
        HeroNode hero3 = new HeroNode(3,"许馨文","新闻");
        HeroNode hero4 = new HeroNode(4,"蔡徐坤","Kun");
        HeroNode hero5 = new HeroNode(5,"陈幸童","tong");
        HeroNode hero6 = new HeroNode(6,"懂帆","fan");
        HeroNode hero7 = new HeroNode(7,"虎丝","小老虎");

        SingleLinkedList sl1 = new SingleLinkedList();
        sl1.addByOrder(hero1);
        sl1.addByOrder(hero4);
        sl1.addByOrder(hero7);
        sl1.addByOrder(hero5);

        System.out.println("链表1：");
        sl1.list();
        SingleLinkedList sl2 = new SingleLinkedList();
        sl2.addByOrder(hero6);
        sl2.addByOrder(hero2);
        sl2.addByOrder(hero3);
        //sl2.addByOrder(hero4);
        System.out.println("链表2：");
        sl2.list();

        //链表连接
        System.out.println("连接后的链表：");
        SingleLinkedList sl = mergeList(sl1, sl2);
        sl.list();


//        reversetList(sl);

//        System.out.println("反转后的单链表： ");
//        sl.list();

//        reversePrint(sl.getHead());




//        sl.del(4);

//        System.out.println("删除后的队列");
//        sl.list();
//
//        int length = getLength(sl);
//
//        System.out.println("该单链表的有效节点为：" + length);
//
//        HeroNode lin = null;
//        try {
//            lin = findLastIndexNode(2, sl);
//            System.out.println(lin);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }



//        sl.update(new HeroNode(3,"许馨文","新闻姐姐"));
//
//        System.out.println("修改后的链表");
//        sl.list();
    }
    //合并两个有序的单链表，要求合并后任然有序
    public static SingleLinkedList mergeList(SingleLinkedList s1,SingleLinkedList s2){
        HeroNode p1 = s1.getHead().next;
        HeroNode p2 = s2.getHead().next;
        SingleLinkedList sl = new SingleLinkedList();
        HeroNode h = sl.getHead();
        HeroNode p3 = h;
        while(p1 != null && p2 != null){
            if(p1.no < p2.no){
                p3.next = p1;
                p1 = p1.next;
                p3 = p3.next;
            }else{
                p3.next = p2;
                p2 = p2.next;
                p3 = p3.next;
            }
        }
        if(p1.next == null){
            p3.next = p2;
        }else {
            p3.next = p1;
        }
        return sl;
    }

    //递归反向打印链表
    public static void reversePrint(HeroNode head){
        //HeroNode p = head;
        if(head.next != null){
           reversePrint(head.next);
            System.out.println(head.next);
           return;
        }
    }

    //将单链表反转
    public static void reversetList(SingleLinkedList sl){
        HeroNode head = sl.getHead();
        HeroNode p = head;
        HeroNode reverhead = new HeroNode(0,"","");
        while(true){
            if(head.next == null){
                System.out.println("该链表为空");
                return;
            }
            p = p.next;
            while (p != null){
                HeroNode p2 = reverhead.next;
                reverhead.next = p;
                p = p.next;
                reverhead.next.next = p2;
            }
            head.next = reverhead.next;
            break;
        }
    }

    //查找单链表中的倒数第K个结点
    public static HeroNode findLastIndexNode(int k,SingleLinkedList sl){
        int length = getLength(sl);
        if(k > length){
            throw new RuntimeException("改单链表长度未符合查找条件");
        }
        HeroNode s = sl.getHead();
        HeroNode q = sl.getHead();
        for(int i = 0;i < k - 1;i++){
            q = q.next;
        }
        while(q.next != null){
            q = q.next;
            s = s.next;
        }
        return s;
    }

    //查找链表的有效节点
    public static int getLength(SingleLinkedList sl){
        HeroNode p = sl.getHead();
        int length = 0;
        while(p.next != null){
            length++;
            p = p.next;
        }
        return length;
    }
}

class SingleLinkedList{

    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead(){
        return head;
    }

    public SingleLinkedList(){

    }

    //链尾插入新的英雄
    public void add(HeroNode hero){
        //利用辅助变量遍历链表以找到最后节点
        HeroNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = hero;
    }

    //按照no编号排序插入
    public void addByOrder(HeroNode hero){
        HeroNode temp = head;
        boolean flag = true;
        while(temp.next != null){
            if(temp.next.no > hero.no){
                break;
            }else if(temp.next.no == hero.no){
                flag = false;
                System.out.println("准备的英雄编号" + hero.no + "已存在，添加失败");
                break;
            }
            temp = temp.next;
        }

        if(flag){
            hero.next = temp.next;
            temp.next = hero;
        }
    }

    //修改数据
    public void update(HeroNode hero){
        if(head.next == null){
            System.out.println("该链表为空");
        }
        HeroNode p = head;
        while(p.next != null){
            if(p.next.no == hero.no){
                hero.next = p.next.next;
                p.next = hero;
                return;
            }
            p = p.next;
        }
        System.out.println("未找到该英雄编号");
    }

    //删除节点
    public void del(int no){
        HeroNode p = head;
        while(p.next != null){
            if(p.next.no == no){
                p.next = p.next.next;
                return;
            }
            p = p.next;
        }
        System.out.println("查无此编号");
    }

    //显示链表
    public void list(){
        HeroNode temp = head;
        while(temp.next != null){
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

}

//定义英雄类
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no,String name,String nickname){
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