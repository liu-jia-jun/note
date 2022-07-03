package code;

/**
 * @author 刘佳俊
 */
public class _1480_RunningSum {
    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;

    }
}
