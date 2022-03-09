package data_structure.stack;

/**
 * @author 刘佳俊
 * 计算器
 */
public class Calculator {


     ArrayStack numberStack;// 数栈
     ArrayStack operatorStack;// 符号栈

    public Calculator() {
        numberStack = new ArrayStack(10);
        operatorStack = new ArrayStack(10);
    }

    public Calculator(int numberStackMaxSize, int operatorStackMaxSize) {
        numberStack = new ArrayStack(numberStackMaxSize);
        operatorStack = new ArrayStack(operatorStackMaxSize);
    }

    public int priority(char oper) {// 判断运算符的优先级，此处仅考虑 + - * /
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }



    public boolean isOperator(char oper) {// 判断输入是否为操作符
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    public int cal(int right, int left, char oper) {
        int result = 0;

        switch (oper) {
            case '+':
                result = left + right;
                break;
            case '-':
                result = left - right;
                break;
            case '*':
                result = left * right;
                break;
            case '/':
                result = left / right;
                break;
            default:
                result = 0;
        }
        return result;
    }





}
