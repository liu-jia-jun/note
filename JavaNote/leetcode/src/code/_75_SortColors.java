package code;

/**
 * @author 刘佳俊
 *
 *
 * 75. 颜色分类:
 *          给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *          我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *  思路:
 *      1. 荷兰国旗问题
 *      2. 我们取出一个数字作为中间值 , 将大于这个数的放在右边 , 将小于这个数的放在左边
 *      3. 假设 当前数为 nums[index] 中间的数表示为mid 我们将mid作为中间值来进行比较  left 和 right 作为左边和右边的边界情况
 *
 *          1). 刚开始 left = -1 , right = nums.length 因为 我们刚开始 大于这个数或者小于这个数的个数都是 0
 *          2). 如果 nums[index] < mid 时
 *              首先我们应该要 将 left++ 因为我们已经找到了一个小于当前数的值
 *              之后我们将 nums[index] 与 nums[left] 进行交换确保nums[left]是小于当前数的值
 *              并且 index ++ 因为我们可以确定 nums[index] 是小于 mid的
 *
 *          3). 如果 nums[index] == mid 时
 *              此时我们并不需要进行数据的交换 所以我只需要 index ++ 即可
 *
 *          4). 如果 nums[index] > mid 时
 *              首先我们应该要 将 right-- 因为我们已经找到了一个大于当前数的值
 *              之后我们将 nums[index] 与 nums[right] 进行交换确保nums[right]是大于当前数的值
 *              此时我们并不能直接 index++ 因为 这个数是从后面的值交换过来的 后面的值我们并不能确定他的大小
 *              所以我们要将交换之后的值继续作为当前值 继续进行比较
 *
 *      4. 这个可以推广到 快速排序 中的partition过程
 *
 */
public class _75_SortColors {
    public void sortColors(int[] nums) {

        int left = -1;
        int right = nums.length;
        int index = 0;
        while (index < right) {
            if (nums[index] < 1) {
                left++;
                exchange(nums, left, index);
                index++;
            } else if (nums[index] > 1) {
                right--;
                exchange(nums, index, right);
            } else {
                index++;
            }
        }
    }

    public void exchange(int[] nums, int indexLeft, int indexRight) {
        int temp = nums[indexLeft];
        nums[indexLeft] = nums[indexRight];
        nums[indexRight] = temp;
    }
}
