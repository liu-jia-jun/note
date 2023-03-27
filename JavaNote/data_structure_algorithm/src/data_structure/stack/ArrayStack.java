package data_structure.stack;

import java.util.Arrays;

/**
 * @author 刘佳俊
 */
public class ArrayStack {
    private int maxsize;// 栈大小
    private int[] stack;// 用数组模拟栈
    private int top = -1;// 栈顶

    // 构造器，在构造器中实例化数组用来模拟栈
    public ArrayStack() {
        this.maxsize = 10;
        this.stack = new int[10];
    }

    public ArrayStack(int maxsize) {
        this.maxsize = 10;
        this.stack = new int[maxsize];

    }

    // 判空
    public boolean isEmpty() {
        return top == -1;
    }

    // 判满
    public boolean isFull() {
        return top == maxsize - 1;
    }
    // 入栈
    public void push(int i){
        if(isFull()){
           throw new RuntimeException("栈满");
        }
        top++;
        stack[top]=i;
    }
    // 出栈
    public int pull(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        top--;
        return stack[top+1];
    }

    public void showStack(){
        int n = this.top;
        System.out.println(n);
        while(n>=0){
            System.out.println(stack[n]);
            n--;
        }
    }
    // 返回栈顶元素，但不出栈
    public int peek(){
        return stack[top];
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "maxsize=" + maxsize +
                ", stack=" + Arrays.toString(stack) +
                ", top=" + top +
                '}';
    }
}
