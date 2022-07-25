package com.changing.stack;

/**
 * @author changing
 * @create 2021-08-22 22:23
 */
public class CalculatorTest {

    public static void main(String[] args) {
        ArrayStack2 numstack = new ArrayStack2(10);
        ArrayStack2 operstack = new ArrayStack2(10);
//        operstack.push('+');
//        operstack.list();

        String formula = "90-23*8-6-2";

        int index = 0;//遍历公式的索引
        int num1 = 0;
        int num2 = 0;
        int oper = 0;

        int result = 0;
        char temp = ' ';

        String num = "";

        while(index < formula.length()){
            temp = formula.charAt(index);
            //判断索引所指的当前值为数字还是运算符
            if(operstack.isOper(temp)){//为运算符
                if(!operstack.isEmpty()){
                    while (!operstack.isEmpty() && operstack.priority(temp) <= operstack.priority(operstack.peek())){//一定得先判断是否栈空
                        result = operstack.cal(numstack.pop(), numstack.pop(), operstack.pop());
                        numstack.push(result);
                    }

                        operstack.push(temp);

                }else{
                    operstack.push(temp);
                }
            }else{//为数字
                num += temp;
                if(index == formula.length() - 1){
                    numstack.push(Integer.parseInt(num));

                }else{
                    if(operstack.isOper(formula.charAt(index + 1))){
                        numstack.push(Integer.parseInt(num));
                        num = "";
                    }
                }

            }
            index++;
        }

        while (!operstack.isEmpty()){
            result = operstack.cal(numstack.pop(), numstack.pop(),operstack.pop());
            numstack.push(result);
        }
        System.out.println(numstack.pop());
    }

}
//
//class Calculator{
//
//
//}
class ArrayStack2{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    ArrayStack2(int maxSize){
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

    //查看栈顶元素
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        return stack[top];
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

    //判断运算符的优先级
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if(oper == '+' || oper == '-'){
            return 0;
        }else{
            return -1;
        }
    }
    //判断是否为运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算
    public int cal(int val1,int val2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = val1 + val2;
                break;
            case '-':
                res = val2 - val1;//与出栈顺序相反
                break;
            case '*':
                res = val1 * val2;
                break;
            case '/':
                res = val2 / val1;//与出栈顺序相反
//            default:
//                throw new RuntimeException("输入有误");
        }
        return res;
    }
}