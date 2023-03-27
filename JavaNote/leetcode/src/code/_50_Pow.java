package code;

/**
 * @author 刘佳俊 Pow(x, n)
 * 使用折半计算，每次把n缩小一半，这样n最终会缩小到0，任何数的0次方都为1，这时候我们再往回乘，
 * 如果此时n是偶数，直接把上次递归得到的值算个平方返回即可，
 * 如果是奇数，则还需要乘上个x的值。还有一点需要引起我们的注意的是n有可能为负数，
 * 对于n是负数的情况，我们可以先用其绝对值计算出一个结果再取其倒数即可。
 * 我们让i初始化为n，然后看i是否是2的倍数，是的话x乘以自己，否则res乘以x，i每次循环缩小一半，直到为0停止循环。最后看n的正负，如果为负，返回其倒数。
 */
public class _50_Pow {
    public static void main(String[] args) {
        System.out.println(myPow2(2, -2147483648));
    }

    // 超出时间限制
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {

            if (n <= 1) {
                return x;
            } else if (n % 2 != 0) {
                return myPow(x, n / 2) * myPow(x, n / 2) * x;
            } else {
                return myPow(x, n / 2) * myPow(x, n / 2);
            }
        } else {
            if (n >= -1) {
                return 1 / x;
            } else if (n % 2 != 0) {
                return (1 / x) * (myPow(x, n + 1)) * (myPow(x, n / 2));
            } else {
                return (myPow(x, n / 2)) * (myPow(x, n / 2));
            }
        }

    }



    public static double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = 1;
        int i = n;
        // n有正负数,当n等于-2147483648时转换为正整数会导致溢出
        while (i > 1 || i < -1) {
            if (i % 2 != 0) {
                result = result * x;
            }
            x *= x;
            i = i / 2;
        }
        result *= x;

        return n > 0 ? result : 1 / result;
    }
}

