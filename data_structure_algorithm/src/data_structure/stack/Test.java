package data_structure.stack;

import java.util.Stack;

/**
 * @author 刘佳俊
 */
public class Test {
    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push("(");
        stack.push(")");
        stack.pop();
        System.out.println(stack);


    }
}
