package code;

/**
 * @author 刘佳俊 191. 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 *
 * 注意:这里主要运用的知识是位移(这里是左移),和 与运算
 */
public class _191_HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            // 位运算
            count += (n & (1 << i)) == 0 ? 0 : 1;
        }

        return count;

    }
}
