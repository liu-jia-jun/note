package code;

/**
 * @author 刘佳俊
 *
 *   只出现一次的数字:
 *      给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 *   思路:
 *       1. 整体异或法
 *
 *       2. 当两个相同的数异或之后得到0 当一个数与0异或得到的是本身
 *       3. 因为题目表明除了某个元素只出现一次以外，其余每个元素均出现两次
 *       4. 所以出现两次的元素会两两异或变成0
 *       5. 最后的奇数个的元素整体上来看是和0异或 所以得到的就是需要返回的数
 *
 *
 *
 *
 */
public class _136_SingleNumber {

    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i=1;i<nums.length;i++){
            result ^= nums[i];
        }
        return result;
    }
}
