package code;

/**
 * @author 刘佳俊
 *
 * 二分查找
 *
 */
public class _704_Search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        int index = -1;

        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            if (nums[middle] == target) {
                index = middle;
                break;
            }
        }
        return index;
    }
}
