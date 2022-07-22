package code;

/**
 * @author 刘佳俊
 *
 *  山脉数组的峰顶索引
 *
 *  思路:
 *      1. 局部最大值最小值问题,使用二分法 和 分情况讨论
 *
 *      2. 分情况讨论, 共有三种情况,这里寻找的是峰值,我们以最大值为例 最小同理
 *
 *          (1). 当数组中第一个数大于第二个数,我们可以说,第一个数为峰值直接返回即可
 *          (2). 当数组中最后一个数大于倒数第二个数,我们也可以说最后一个数为峰值直接返回即可
 *
 *          (3). 以上情况都不符合,那么数组整体的形式是从左往右是递增形式,从右往左也是递增形式,所以在这两个数中间必有一个数是峰值
 *              [1]. 此时我们使用二分法,找到中间的数,如果中间的数均大于两侧的数那么此时中间的数就是峰值
 *              [2]. 如果中间的数均小于两侧的数那么在左边或者右边都有峰值的存在,此时任意选一边
 *              [3]. 如果中间的数大于右边小于左边则继续往左边寻找,如果中间的数小于右边大于左边则往右边寻找
 *
 * 注意: 因为这里的题目限制 所以我们只需要考虑第三种情况即可
 *
 *
 *
 */
public class _852_PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        int index = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                index = mid;
                break;
            }
            if (arr[mid] > arr[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return index;
    }
}
