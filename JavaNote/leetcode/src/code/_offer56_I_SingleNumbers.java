package code;

/**
 * @author 刘佳俊
 *
 * 数组中数字出现的次数:
 *                  一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *                  要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 * 思路:
 *      1. 异或法找 奇数个的数 或者 偶数个的数
 *
 *      2. 根据题目中描述,在一个数组中找出只出现过一次(即奇数次) 的 两个数 设这两个数 为   a , b
 *
 *      3. 第一步 将数组元素整体异或  得到 a^b  根据 a^b 且 a 和 b 不相等 那么 a^b 不会等于 0 所以说 a^b 的二进制值中一定存在 1
 *          例如 : a^b = 10  -> 001010   在二进制位中  我们取 异或值的最右边的1 也就是  000010 那么 a 和 b 在 第二位的 二进制位肯定是不相同的
 *          更加这个我们可以将数组分成在这个位置上 二进制位为 1 和 二进制位为 0  的两组元素
 *          那么这个问题 就拆解成  两个数组  这两个数组中均只有一个数只出现一次 其他的数均出现两次 分别求这两个数
 *
 *      4. 根据 某个二进制位 进行分组 分组之后的情况 就是 两个数组都是一个只出现过一次的数和剩余的出现过两次的数
 *
 *
 *
 */
public class _offer56_I_SingleNumbers {

    public int[] singleNumbers(int[] nums) {

        int[] result = new int[2];
        int a = 0, b = 0;
        int AxorB = 0;
        for (int num : nums) {
            AxorB ^= num;
        }
        int differentByte = getRightOne(AxorB);
        for (int num : nums) {
            // 根据某一位二进制对 nums 数组进行分组
            if ((num & differentByte) == 0) {
                continue;
            }
            a ^= num;
        }
        result[0] = a;

        // 因为我们根据其中一组数据得出了 a 的值 并且我们又知道了 a^b 的值  根据两个相同的数异或为 0 一个数和0异或还是这个数  异或运算符合交换律
        // 我们可以直接得出 b 的值
        b = a ^ AxorB;
        result[1] = b;

        return result;

    }

    // 获取一个数的最右边的1 (二进制)
    // eg:  10 -> 1010 最右边的二进制 应该是 0010 值为 2
    public int getRightOne(int num) {
        // 一个数最右边的一
        int rightOne = 0;
        for (int i = 0; i < 32; i++) {
            rightOne = num & (1 << i);
            if (rightOne != 0) {
                break;
            }
        }
        return rightOne;
    }
}
