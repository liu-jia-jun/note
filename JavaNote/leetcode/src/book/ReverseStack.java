package book;

import java.util.Stack;

/**
 * @author 刘佳俊
 *
 * 逆序栈 :
 *          仅通过 递归函数 将一个栈里面的元素 逆序  12345 变成 54321 不允许使用其他数据结构
 *
 *
 * 思路 :
 *       1. 我们可以通过一个递归函数的方法调用 来模拟一个栈 通过方法的递归调用 在调用过程中 存储 数据
 *              递归函数 最先执行的 最后结束  最后执行的  最先结束  满足 先进后出的 概念
 *
 *       2. 我们先通过getStackBottom 函数弹出并返回 当前栈中的最底部的元素 存储到当前的 方法栈中
 *       3. 我们通过 reverseStack 递归函数去 递归的 弹出 栈中最底部的元素 当栈为空的之后 递归回调 将我们存储在 方法栈中的 元素push 进 stack中
 *
 *       4. 相当于 在 reverseStack 函数递归栈顶元素时 取出并保存的 是此时栈底 的元素( getStackBottom 函数) 通过递归调用 保存在方法栈中
 *               当 reverseStack 函数递归到最后一个元素时 就开始将 开始时 栈顶的元素 开始入栈 入栈之后 就会变成栈底元素
 *
 *                至此完成逆序栈
 *
 *
 *
 */
public class  ReverseStack {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.stream().forEach((item)->{
            System.out.print(item);
        });
        reverseStack(stack);
        System.out.println();
        stack.stream().forEach((item)->{
            System.out.print(item);
        });
    }

    public static void reverseStack(Stack<Integer> stack){

        if(stack==null||stack.isEmpty()){
            return ;
        }

        int stackBottom = getStackBottom(stack);
        reverseStack(stack);
        stack.push(stackBottom);

    }

    public static int getStackBottom(Stack<Integer> stack){
        Integer pop = stack.pop();
        if(stack.isEmpty()){
            return pop;
        }
        int bottom = getStackBottom(stack);
        stack.push(pop);

        return bottom;
    }






}

