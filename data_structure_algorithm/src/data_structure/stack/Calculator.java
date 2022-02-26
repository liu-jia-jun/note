package data_structure.stack;

/**
 * @author 刘佳俊
 * 计算器
 */
public class Calculator {


    private ArrayStack numberStack;// 数栈
    private ArrayStack operatorStack;// 符号栈

    public Calculator() {
        numberStack = new ArrayStack(10);
        operatorStack = new ArrayStack(10);
    }

    public Calculator(int numberStackMaxSize, int operatorStackMaxSize) {
        numberStack = new ArrayStack(numberStackMaxSize);
        operatorStack = new ArrayStack(operatorStackMaxSize);
    }

    public int priority(int oper) {// 判断运算符的优先级，此处仅考虑 + - * /
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


    /**
     * 简易计算器
     * <p>
     * 除括号，多符号（负数）的多位数的加减乘除
     *
     * @param expression
     * @return
     */
    public int simpleCalculator(String expression) {


        int result = 0;
        int number;
        int index = 0;
        int len = expression.length();
        char oper;
        int left;
        int right;

        while (index < len) {
            oper = expression.charAt(index);
            if (!isOperator(oper)) {
                number = oper - 48;
                for (int i = index + 1; i < len; i++) {
                    oper = expression.charAt(i);
                    if (!isOperator(oper)) {
                        number = number * 10 + (oper - 48);
                        index = i;
                    } else {
                        index = i - 1;
                        break;
                    }
                }
                numberStack.push(number);
            } else {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(oper);
                } else {
                    if (priority(oper) <= priority(operatorStack.peek())) {
                        right = numberStack.pull();
                        left = numberStack.pull();
                        result = cal(right, left, (char) operatorStack.pull());
                        numberStack.push(result);
                        operatorStack.push(oper);
                    } else {
                        operatorStack.push(oper);
                    }
                }
            }
            index++;
        }
        System.out.println(numberStack);
        System.out.println(operatorStack);

        while (!operatorStack.isEmpty()) {
            right = numberStack.pull();
            left = numberStack.pull();
            result = cal(right, left, (char) operatorStack.pull());
            numberStack.push(result);
        }
        result = numberStack.pull();
        return result;
    }


}
