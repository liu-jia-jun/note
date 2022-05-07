package code;

/**
 * @author 刘佳俊
 */
public class _0_ {

    public static void main(String[] args) {
        System.out.println(hammingWeight(-1));
    }

    public static int hammingWeight(int n) {


        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n & (1 << i)) == 0 ? 0 : 1;
        }

        return count;

    }

    // 因为将 -2147483648 转成正数会越界，但是将 2147483647 转成负数，则不会
// 所以，我们将 a 和 b 都转成负数
// 时间复杂度：O(n)，n 是最大值 2147483647 --> 10^10 --> 超时
    public static int divide2(int a, int b) {
        // 32 位最大值：2^31 - 1 = 2147483647
        // 32 位最小值：-2^31 = -2147483648
        // -2147483648 / (-1) = 2147483648 > 2147483647 越界了
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        // 环境只支持存储 32 位整数
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }
        int res = 0;
        while (a <= b) {
            a -= b;
            res++;
        }
        // bug 修复：因为不能使用乘号，所以将乘号换成三目运算符
        return sign == 1 ? res : -res;
    }

    public static int divide(int a, int b) {
        if (a == 0) {
            return 0;
        }

        if (b == 1) {
            if (a == Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return a;
            }
        }
        if (b == -1) {
            if (a == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -a;
            }
        }

        int i = a > 0 ? -a : a;
        int j = b > 0 ? -b : b;
        int count = 0;
        while (i <= j) {
            i = i - j;
            count--;
        }
        if (count == Integer.MIN_VALUE) {
            if (a > 0 && b > 0 || a < 0 && b < 0) {
                count = -(count + 1);
            }
        } else {
            if (a > 0 && b > 0 || a < 0 && b < 0) {
                count = -count;
            }
        }
        return count;
    }
}
