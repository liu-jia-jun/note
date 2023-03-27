package code;

/**
 * @author 刘佳俊
 *
 *  在排序数组中查找元素的第一个和最后一个位置
 *
 *      给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 *      如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 *  思路:
 *       1. 二分查找
 *       2. 我们直接使用二分查找,查到之后我们可以往左和往右遍历,看看是否存在于target相等的元素
 *
 *       3. 此问题可以看作 数组中元素与target相等的最左边元素的下标和最右边的下标
 *
 *
 *
 *
 */
public class _34_SearchRange {

    public int[] searchRange(int[] nums, int target) {

        int[] result = {-1, -1};
        if (nums.length == 0 || target > nums[nums.length - 1] || target < nums[0]) {

            return result;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                result[0] = mid;
                result[1] = mid;
                break;
            }
        }

        // 往左看 是否有target 有就更新result[0] 的值,这个值表示target的左范围
        // 我们这进行的是自减操作 且比较的是 nums[result[0] - 1]
        while (result[0] > 0) {
            if (nums[result[0]] == nums[result[0] - 1]) {
                result[0]--;
            } else {
                break;
            }
        }
        // 往右看 是否有target 有就更新result[1] 的值,这个值表示target的右范围
        // 注意,我们这里 result[1]>=0 因为我们这里是 自增操作 且比较的是 nums[result[1] + 1] 所以下标为0 是可行的
        while (result[1] >= 0 && result[1] < nums.length - 1) {
            if (nums[result[1]] == nums[result[1] + 1]) {
                result[1]++;
            } else {
                break;
            }
        }

        // 注意上述两个while循环中的条件都是保证数组下标不越界
        return result;

    }
}
