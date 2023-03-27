package code;

import java.util.HashMap;

/**
 * @author 刘佳俊
 *
 * 数组中重复的数字
 *
 * 思路:
 *      1. 本题为简单题,可以使用计数的方式遍历数组并且记录下出现过的数子,下次遇到直接返回该数字
 *
 *      2. 上述方法可行但是时间复杂度不是很好
 *
 *      3. 我们可以使用原地交换的方式来实现本题
 *
 *      遍历数组 nums，设索引初始值为 i = 0 :
 *      若 nums[i] = i： 说明此数字已在对应索引位置，无需交换，因此跳过；
 *      若 nums[nums[i]] = nums[i]： 代表索引 nums[i] 处和索引 i 处的元素值都为 nums[i] ，即找到一组重复值，返回此值 nums[i]
 *      否则： 交换索引为 i 和 nums[i] 的元素值，将此数字交换至对应索引位置。
 *      若遍历完毕尚未返回，则返回 -1
 *
 *
 *
 *
 *
 *
 */
public class _offer03_FindRepeatNumber {

    // 原地交换
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        // 注意: 这里不能使用for 循环,
        while (i < nums.length) {
            if (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                } else {
                    exchange(nums, i, nums[i]);
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public int findRepeatNumber2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                return nums[i];
            }
        }
        return 0;
    }

    public int findRepeatNumber3(int[] nums) {

        int[] value = new int[1000001];
        for (int i = 0; i < nums.length; i++) {
            if (value[nums[i]] == 0) {
                value[nums[i]]++;
            } else {
                return nums[i];
            }
        }
        return -1;
    }
}
