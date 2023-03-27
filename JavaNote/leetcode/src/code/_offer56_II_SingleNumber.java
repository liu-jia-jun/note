package code;

/**
 * @author 刘佳俊
 *
 * 数组中数字出现的次数 II:
 *                      在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 *  思路:
 *       1. 位运算 在数组中找出只出现过一次的元素 , 并且有且只有一个只出现过一次
 *
 *       2. 根据题目可以得出, 有且只有一个元素只出现过一次 , 其余元素都出现过三次
 *              注意这里两组元素的奇偶性相同  不能使用异或的方式得出 , 如果 是两种元素出现的次数的奇偶性不同 , 我们可以使用整体异或的方式得出
 *
 *       3. 这里不能使用整体异或 但是我们可以想到  一个数出现了一次  其他数出现了三次  那么 在所有数的二进制位中 也有这样的性质
 *
 *       4. 具体作法
 *          1). 我们创建一个大小为三十二的数组 , 并将 nums 中元素的二进制位中的 1 的个数存储在 这个数组中  将 这个数组的元素 对三取余
 *          2). 那我们就可以很简单的直到 只出现过一次的那个数的三十二位二进制 长什么样  之后根据二进制 转换成 十进制数并返回
 *
 *          eg: 这里我们以四位二进制 为例
 *              [1,2,2,2] -> [0001,0010,0010,0010]
 *
 *              byteNums -> [1,3,0,0]  因为 上面的二进制对应的各个位上 1 的个数 例如 在上述数组中 右边第一位上为1 的 个数只有一个  第二位上为1 的个数有三个
 *
 *              byteNums 对三取余  -> [1,0,0,0]
 *
 *              根据取余之后的byteNums数组得到只出现过一次的数
 *
 *              result = 0001 -> 1 result等于 1
 *
 *
 *        5. 根据这题 我们还可以推广成   在一个 数组中 有两种元素 一种是出现过 1 次的元素  另一种是都出现过 m 次的元素 (本题是出现 3 次)
 *
 */
public class _offer56_II_SingleNumber {

    public static int singleNumber(int[] nums) {

        int result=0;

        int[] byteNums = new int[32];


        // 将nums 数组中的元素的各个二进制位上 1 的总个数计算出来存储在byteNums中
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                // 如果 num[i] 在第j位上的数不是0 那么就是1
                // 此时我们在对应的byteNums数组中对应下标的元素使其自增,计算出就可以nums 数组中的元素的各个二进制位上 1 的总个数
                if ((nums[i]&(1<<j))!=0) {
                    byteNums[j]++;
                }
            }
        }

        //根据这个数的二进制 还原成十进制
        for (int i = 0; i < 32; i++) {
            // 当第i个元素对3取余之后不等于0 那么证明在第i位的二进制位上的数是1
            if(byteNums[i]%3!=0){
                // 左移 i 位
                result += 1<<i;
            }
        }

        return result;
    }
}