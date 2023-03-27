package code;

import java.util.*;

/**
 * @author 刘佳俊
 * <p>
 * 最小的k个数
 *
 *
 * 思路:
 *      1. 这种返回数组中前第k个最大或者最小的数都是典型的  dk问题
 *
 *      2. 我们可以使用快速排序中的思想使用快速选择的方式来写,无论如何都是可以在数组中找到第k大或者第k小的数,然后返回左边全部或者右边全部
 *
 *      3. 我们可以使用优先队列来写,通过构建元素个数为k的大根堆或者是小根堆来实现(这里要注意需要懂堆排序的实现)
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
    public int[] getLeastNumbers3(int[] arr, int k) {
        poccess(arr, 0, arr.length - 1, k);
        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    private void poccess(int[] arr, int left, int right, int k) {

        if (left > right) {
            return;
        }
        int l = left;
        int r = right;
        int temp = arr[left];

        while (l < r) {
            while (l < r && arr[r] >= temp) {
                r--;
            }
            while (l < r && arr[l] <= temp) {
                l++;
            }

            if (l < r) {
                exchange(arr, l, r);
            }

        }
        exchange(arr, left, l);

        if (k > l) {
            poccess(arr, l + 1, right, k);
        }
        if (k < l) {
            poccess(arr, left, r - 1, k);
        }
    }
    private void exchange(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }


}
