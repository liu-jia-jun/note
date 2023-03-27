package code;

import java.util.Arrays;

/**
 * @author 刘佳俊
 *
 * 排序数组
 *
 * 思路:
 *      1. 冒泡排序
 *          两层循环 , 相邻两个元素进行比较进行调换
 *          外层循环用于设置循环次数 , 内层循环用与 相邻两个数进行比较转换
 *
 *      2. 选择排序
 *          两层循环 , 通过一个变量记下值最大的数组元素的下标
 *          内存循环用于判断那个元素的值是最大的 , 并记下下标
 *          外层循环用于将最大值的元素与未排序的最前面的元素或者最后面的元素进行转换
 *
 *      3. 快速排序
 *       TODO
 *
 *
 *      4. 归并排序
 *          归并排序的主要思想是通过归并进行排序 , 即将两个已知有序的子数组 通过归并 合成一个有序的大数组
 *          当我们将数组元素进行细分成子数组 , 当子数组的元素只有一个的时候 , 此时这个子数组就是已知有序的
 *
 *          例如   8,5,2,9
 *              1. 8,5一组 2,9 一组
 *
 *              2. 8 一组 5 一组 , 2 一组  9 一组
 *
 *              3. 8 和 5 两个子数组归并成一个有序的较大的数组
 *
 *              4. 5,8 2,9
 *
 *              通过归并之后 变成了 5,8  2,9  此时两个子数组又是有序的 再次归并就可以得到  2,5,8,9
 *
 *
 */
public class _912_SortArray {
    public static void main(String[] args) {
        _912_SortArray obj = new _912_SortArray();
        int[] nums = {5,2,3,1};
        int[] arr = obj.sortArray3(nums);
        System.out.println(Arrays.toString(arr));
    }



    // 快排
    public int[] sortArray3(int[] nums) {
        partition(nums, 0, nums.length - 1);
        return nums;
    }

    public void partition(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        // 随机选出范围内的一个数 作为中间数 此时
        int mid = nums[left + (int) (Math.random() * (right - left+1))];

        System.out.println(mid);
        int l = left - 1;
        int r = right + 1;
        int index = left;
        while (index < r) {
            if (nums[index] < mid) {
                l++;
                exchange(nums, l, index);
                index++;
            } else if (nums[index] > mid) {
                r--;
                exchange(nums, index, r);
            } else {
                index++;
            }
        }

        partition(nums, left, l);
        partition(nums, r, right);

    }

    // 归并排序
    public int[] sortArray4(int[] nums) {

        process(nums, 0, nums.length - 1);
        return nums;
    }

    public void process(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(nums, left, mid);
        process(nums, mid + 1, right);


        merge(nums, left, mid, right);

    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] arr = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int index = 0;
        while (l <= mid && r <= right) {
            if (nums[l] < nums[r]) {
                arr[index] = nums[l];
                index++;
                l++;
            } else {
                arr[index] = nums[r];
                index++;
                r++;
            }
        }
        while (l <= mid) {
            arr[index] = nums[l];
            index++;
            l++;
        }
        while (r <= right) {
            arr[index] = nums[r];
            index++;
            r++;
        }

        for (int i = 0; i < arr.length; i++) {
            nums[left + i] = arr[i];
        }

    }

    // 冒泡排序 (时间复杂度较高,会超时)
    public int[] sortArray1(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
//                    exchange(nums,j,j+1);
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }


    // 选择排序
    public int[] sortArray2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            exchange(nums, i, minIndex);
        }
        return nums;
    }

    public static void exchange(int[] nums, int indexLeft, int indexRight) {
        int temp = nums[indexLeft];
        nums[indexLeft] = nums[indexRight];
        nums[indexRight] = temp;
    }
}
