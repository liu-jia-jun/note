package code;

/**
 * @author 刘佳俊
 *
 * 搜索旋转排序数组:
 *                  整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 *
 * 思路:
 *      1. 旋转数组问题
 *      2. 在旋转数组找一个数并返回它的下标如果没有找到返回 -1
 *
 *      3. 旋转数组在整体上不是有序的,但是我们可以先找到旋转点即最小值的下标 minIndex
 *      4. 找到最小值的下标之后将数组分成两个部分,  0 ~ minIndex -1  和  minIndex ~ nums.length-1
 *      5. 在这两个部分中数组是有序的且都是单调递增,此时我们再用二分法分别对这两个数组进行查找值即可
 *
 */
public class _33_Search {

    // 整体算法时间复杂度为 O(log n)
    public int search(int[] nums, int target) {

        // 第一步 找出旋转点,最小值, 旋转数组找最值问题

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }


        }
        // 找到旋转点即最小值的下标
        int minIndex = left;

        // 需要返回的target 的下标
        int index = -1;
        /*
            找到旋转点 此时旋转点的左边为有序,旋转点的右边为有序
         */

        // 左边

        left = 0;
        right = minIndex - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                index = mid;
                break;
            }
        }

        // 如果左边找到则直接返回
        if (index != -1) {
            return index;
        }

        // 右边
        left = minIndex;
        right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;

    }
}
