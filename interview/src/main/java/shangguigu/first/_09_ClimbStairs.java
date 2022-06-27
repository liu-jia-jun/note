package shangguigu.first;

/**
 * @author 刘佳俊
 * <p>
 * 爬楼梯,一次只能爬一个或者两个台阶,求总共有多少中走法
 */
public class _09_ClimbStairs {

    public static void main(String[] args) {
        System.out.println(loop1(4));
    }


    // 递归实现
    public static int loop1(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return loop1(n - 1) + loop1(n - 2);
    }

    // 递推实现
    public static int loop2(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("非法参数,n必须为大于0的正整数");
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int one = 2;
        int two = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {

            // 最后跨2步 + 最后跨1步
            sum = two + one;
            two = one;
            one = sum;
        }
        return sum;
    }

}
