package code;

/**
 * @author 刘佳俊
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围[−2的31次方, 2的31次方− 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）
 */
public class _7_ReverseInt {
    public int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            sum = sum * 10 + x % 10;
            x = x / 10;
        }

        /**
         * 这个地方我们巧妙地使用 long 类型， long 类型可以存储8个字节，可以完整的存储数据，但是 int 类型只有i四个字节
         * 使用 int 进行存储会导致失去精度
         * 我们通过 long 类型与 int 类型之间转换会出现数值精度的变化，此时我们可以通过转换前后的数值是否相等，来判断这个数是否溢出
         */

        return sum == (int) sum ? (int) sum : 0;
    }
}