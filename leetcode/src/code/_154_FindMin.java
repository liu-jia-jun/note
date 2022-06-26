package code;

/**
 * @author 刘佳俊
 */
public class _154_FindMin {
    public int findMin(int[] nums) {
        int result = nums[0];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                result = nums[(i + 1) % nums.length];
                break;
            }
        }
        return result;
    }
}
