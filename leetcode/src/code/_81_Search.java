package code;

/**
 * @author 刘佳俊
 *
 *   搜索旋转排序数组 II
 *
 *   在第33题搜索旋转排序数组的基础上加上了数组元素可重复
 *
 *   思路:
 *       1. 旋转数组问题  二分法
 *       2. 与33题解法相似,但是我们需要处理数组元素相等的情况
 *       3. 当我们的 左值 == 中值 == 右值 时,我们无法判断向左还是向右缩小边界所以我们可以 left++ , right-- 即边界向中间靠拢 来处理这种情况
 *       4. 我们还需要注意当我们找到最小值时,此时数组的两边不一定是有序的 例如:    5 5 1 1 1 3 3 此时我们的左右都不是有序的
 *              我们可以使用两个变量来解决最小值重复的问题,即最左最小值 和 最右最小值
 *
 *       5. 在确定最小值的两个下标之前我们可以先对最小值判断,之后再用二分法对左右子数组进行元素查找
 *
 *       6. 注意: 此时我们还需要判断右边子数组的单调性, 可能单调递增可能单调递减 还有可能都相等
 *       7. 左边子数组是保持单调递增的
 *
 *
 *
 */
public class _81_Search {

    public boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == nums[right] && nums[mid] == nums[left]) {
                left++;
                right--;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int minIndexLeft = left;
        int minIndexRight = left;

        if (nums[minIndexLeft] == target) {
            return true;
        }

        while (minIndexLeft > 0) {
            if (nums[minIndexLeft] == nums[minIndexLeft - 1]) {
                minIndexLeft--;
            } else {
                break;
            }


        }
        while (minIndexRight < nums.length - 1) {

            if (nums[minIndexRight] == nums[minIndexRight + 1]) {
                minIndexRight++;
            } else {
                break;
            }

        }


        // 左边

        left = 0;
        right = minIndexLeft - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        // 右边
        left = minIndexRight + 1;
        right = nums.length - 1;


        while (left <= right) {
            mid = left + (right - left) / 2;

            // 两种可能性 单调递减 和其他
            if (nums[left] > nums[right]) {
                if (nums[mid] > target) {
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    right = mid - 1;
                } else {
                    return true;
                }
            } else {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
