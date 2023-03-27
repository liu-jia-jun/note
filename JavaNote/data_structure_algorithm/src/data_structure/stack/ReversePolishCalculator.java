package data_structure.stack;

import data_structure.queue.QueueByArray;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author 刘佳俊
 */
public class ReversePolishCalculator extends Calculator {
    public static void main(String[] args) {
        ReversePolishCalculator calculator = new ReversePolishCalculator();
        System.out.println(calculator.reversePolishCalculator("1+((2+3)*4)-5/5"));
    }

    public ReversePolishCalculator() {
        super();
    }

    /**
     * 通过字符串表达式转换为逆波兰表达式，即后缀表达式
     */
    public String reversePolish(String expression) {
        char[] chars = expression.toCharArray();
        String str = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                operatorStack.push(chars[i]);
            } else if (chars[i] == ')') {
                // 当符号为右括号时，我们需要依次将符号栈中的符号依次弹出并拼接到字符串中
                while(true){
                    if (operatorStack.peek() != '(') {
                        str += (char) operatorStack.pull();
                    } else {
                        operatorStack.pull();
                        break;
                    }
                }


            } else if (isOperator(chars[i])) {
                // 当符号为运算操作符时，我们需要进行比较符号栈的栈顶元素如果优先级大，则入栈，
                // 如果小则将符号栈中的符号弹出并拼接到字符串中，并重复该过程直到比栈顶元素大并入栈
                while (true) {
                    if (operatorStack.isEmpty() || operatorStack.peek() == '(') {
                        operatorStack.push(chars[i]);
                        break;
                    } else if (priority((char) operatorStack.peek()) < priority(chars[i])) {
                        operatorStack.push(chars[i]);
                        break;
                    } else {
                        str += (char) operatorStack.pull();
                    }
                }
            } else {
                // 如果该字符为数字，直接拼接到字符串中
                str += chars[i];
            }
        }
        while (!operatorStack.isEmpty()){
            str += (char)operatorStack.pull();
        }

        return str;
    }


    public int reversePolishCalculator(String expression) {
        String str= reversePolish(expression);
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(isOperator(chars[i])){
            numberStack.push(cal(numberStack.pull(),numberStack.pull(),chars[i]));
            }else{
                numberStack.push(chars[i]-48);
            }
        }


        return numberStack.pull();
    }
}
