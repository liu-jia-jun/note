package code;

/**
 * @author 刘佳俊
 *
 *  一维数组的动态和
 *
 *  思路:
 *      1. 从第二个数开始,动态和等于上一个数加上原本数组中的数就得到了该位置上的动态和
 */
public class _1480_RunningSum {
    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;

    }
}
