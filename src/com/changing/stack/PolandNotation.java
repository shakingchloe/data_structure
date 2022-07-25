package com.changing.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author changing
 * @create 2021-08-23 12:34
 */
public class PolandNotation {
    public static void main(String[] args) {

        String expression = "1+((2+3)*4)-5";
        List<String> list = toInfixExpressionList(expression);
        System.out.println(list);
        List<String> list1 = parseSuffixExpressionList(list);
        System.out.println(list1);

//        parseSuffixExpressionList(list);



//        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
//
//        String[] str = getListString(suffixExpression);
//        int result = calculate(str);
//        System.out.println(result);

    }
    //中缀转为后缀
    public static List<String> parseSuffixExpressionList(List<String> ls){
        Stack<String> s1 = new Stack<>();
        //Stack<String> es = new Stack<>();
        List<String> el = new ArrayList<>();

        for(String str : ls){
            if(str.matches("\\d+") ){
                el.add(str);
            }else if(str.equals("(")){
                s1.push(str);
            }else if(str.equals(")")){
                while(!s1.peek().equals("(")){
                    el.add(s1.pop());
                }
                s1.pop();
            }else{
                while (s1.size() != 0 && Operation.getValue(str) <= Operation.getValue(s1.peek())){
                    el.add(s1.pop());
                }
                //
                s1.push(str);
            }
        }

        while (s1.size() != 0){
            el.add(s1.pop());
        }
        return el;
    }

    //将逆波兰表达式放入到ArrayList中
    public static String[] getListString(String suffixExpression){
        List<String> list = new ArrayList<>();

        String[] split = suffixExpression.split(" ");

        return split;
    }

    public static int calculate(String[] strarr){

        //创建一个栈
        Stack<String> stack = new Stack<>();
        for(String str : strarr){
            if(str.matches("\\d+")){
                stack.push(str);
            }else{
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = cal(num1, num2, str.charAt(0));
                stack.push("" + result);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    //计算
    public static int cal(int val1,int val2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = val1 + val2;
                break;
            case '-':
                res = val1 - val2;//与出栈顺序相反
                break;
            case '*':
                res = val1 * val2;
                break;
            case '/':
                res = val1 / val2;//与出栈顺序相反
//            default:
//                throw new RuntimeException("输入有误");
        }
        return res;
    }

    //将中缀表达式转成对应的list
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<>();
        int index = 0;
        String str;
        char c;
        do{
            if((c=s.charAt(index)) < 48 || (c=s.charAt(index)) > 57){
                ls.add("" + c);
                index++;
            }else{
                str = "";
                while(index < s.length() && (c=s.charAt(index)) >= 48 && (c=s.charAt(index)) <= 57){
                    str += c;
                    index++;
                }
                ls.add(str);
            }
        }while (index < s.length());
        return ls;
    }
}

class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation){
        int result = 0;
         switch(operation){
             case "+":
                 result = ADD;
                 break;
             case "-":
                 result = SUB;
                 break;
             case "*":
                 result = MUL;
                 break;
             case "/":
                 result = DIV;
                 break;
             default:
                 System.out.println("不存在该运算符");
         }
         return result;
    }
}
