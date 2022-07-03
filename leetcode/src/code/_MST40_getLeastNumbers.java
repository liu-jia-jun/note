package code;

import java.util.*;

/**
 * @author 刘佳俊
 * <p>
 * 最小的k个数
 */
public class _MST40_getLeastNumbers {

    // 直接通过数组工具类对arr[] 进行排序,之后返回前k个数字
    public int[] getLeastNumbers1(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }


    // 大根堆实现方式
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }

        // 优先队列,底层默认维护一个小根堆,我们可以重写比较器来改成大根堆,
        // 获取k个最小的数用大根堆
        // 获取k个最大的数用小根堆
        Queue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            // 当访问数组中的某个数,这个数小于这个大根堆中的最大值,所以我们应该要将这个数字加入到这个大根堆中
            if (arr[i] < queue.peek()) {
                // 我们维护的是k个元素的大根堆,所以我们这里要先删除最大的
                queue.poll();
                // 然后加入当前满足条件的值,即比最大值要小
                queue.offer(arr[i]);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }







    // 通过快速排序思想来解决,大的放右边,小的放左边
    public int[] getLeastNumbers(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        int[] vec = new int[k];
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    // 基于随机的划分
    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}
