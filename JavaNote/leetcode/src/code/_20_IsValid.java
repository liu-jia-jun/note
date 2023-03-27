package code;

import java.util.Stack;

/**
 * @author 刘佳俊
 * 有效括号
 *
 */
public class _20_IsValid {
    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack<>();
        int n;
        int len = s.length();
        char sign;
        for (int i = 0; i < len; i++) {
            sign = s.charAt(i);
            if (sign == '(' || sign == '[' || sign == '{') {
                stack.push((int) sign);
            } else {
                if (stack.empty()) {
                    return false;
                }
                n = (int) stack.pop();
                if (!((n + 1) == (int) sign || (n + 2) == (int) sign)) {
                    return false;
                }
            }
        }
        return stack.empty() ? true : false;
    }
}
