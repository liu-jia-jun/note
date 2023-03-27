package code;

/**
 * @author 刘佳俊
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 */
public class _35_SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int n = 0;

        if (target <= nums[0]) {
            return 0;
        }

        for (int i = 0; i < nums.length; ) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                return i;
            } else {
                i++;
            }
            n = i;
        }
        return n;
    }
}
