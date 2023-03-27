package code;

import java.util.Stack;

/**
 * @author 刘佳俊
 * 394. 字符串解码
 */
public class _394_DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("2[leetcode]"));
    }

    public static String decodeString(String s) {
        Stack<String> operatorStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        char[] chars = s.toCharArray();
        boolean flag = false;
        String operTemp = "";
        Integer numberTemp;
        String str = "";
        for (int i = 0; i < chars.length; i++) {
            if ('0' <= chars[i] && chars[i] <= '9') {
                if (flag) {
                    numberStack.push(numberStack.pop() * 10 + (chars[i] - 48));
                } else {
                    numberStack.push(chars[i] - 48);
                    flag = true;
                }
            } else if (chars[i] == ']') {
                operTemp = "";

                while (!"[".equals(operatorStack.peek())) {
                    operTemp = (operatorStack.peek() != null ? operatorStack.pop() : "") + operTemp;
//                    operTemp = operatorStack.pop()+operTemp;
                }
                // 将左中括号弹出来
                operatorStack.pop();
                numberTemp = numberStack.pop();
                str = "";
                for (int j = 0; j < numberTemp; j++) {
                    str += operTemp;
                }
                operatorStack.push(str);
                flag = false;

            } else {
                operatorStack.add("" + chars[i]);
                flag = false;
            }
        }
        operTemp = "";
        for (String s1 : operatorStack) {
            operTemp += s1;
        }

        return operTemp;
    }
}
