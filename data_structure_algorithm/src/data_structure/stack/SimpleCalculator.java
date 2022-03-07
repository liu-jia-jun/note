package data_structure.stack;

/**
 * @author 刘佳俊
 */
public class SimpleCalculator extends Calculator{
    public SimpleCalculator(){
        super();
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
                    if (priority(oper) <= priority((char)operatorStack.peek())) {
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
