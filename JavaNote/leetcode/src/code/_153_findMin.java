package code;

/**
 * @author 刘佳俊
 *
 * 寻找旋转排序数组中的最小值
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 思路:
 *      1. 旋转数组问题, 可以使用二分法
 *
 *      2. 在旋转数组中找到最小的那个数
 *      3. 使用二分法查找,需要始终将目标值套住(这里是最小值) 并不断收缩左边界或者右边界
 *
 *      4. 分点: 这边取 左值(左边界值) 右值(有边界值)  中值(有效边界中间的值)
 *          (1). 左值 < 中值 , 中值 < 右值 : 表示在该边界中 数组没有发生旋转 最小值在最左边 所以收缩右边界 如果找的是最大值,则相反操作
 *          (2). 左值 > 中值 , 中值 < 右值 : 表示在该边界中 数组有发生旋转 , 此时我们的最小值还是在左边,所以收缩右边界
 *          (3). 左值 < 中值 , 中值 > 右值 : 表示在该边界中 数组有发生旋转 , 此时我们的最小值是在右边,所以收缩左边界
 *          (4). 左值 > 中值 , 中值 > 右值 : 单调递减 不可能出现
 *
 */
public class _153_findMin {


    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = -1;

        while (left < right) {
            mid = (left + right) / 2;

            if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }

        return nums[left];

    }
}