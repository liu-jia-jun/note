package code;

/**
 * @author 刘佳俊
 *
 * 寻找旋转排序数组中的最小值 II
 *
 * 思路:
 *      1. 排序数组在进过n次旋转时,某种意义来说,其实还是保持有序状态的
 *      2. 我们可以发现,我们从数组最后一个元素开始遍历,当这个元素大于它的前一个元素,就证明,它前面的元素就是整个数组中的最小值
 *      3. 当我们访问最后一个元素的时候,它前一个元素的下标就是[(i + 1) % nums.length],把这个数组想象成一个环
 *      4. [2,2,2,0,1]: 我们可以看到,只有下标为2的元素值比前面一个元素值大
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
