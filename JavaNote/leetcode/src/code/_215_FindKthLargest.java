package code;

import java.util.*;

/**
 * @author 刘佳俊
 *
 * 数组中的第K个最大元素
 *
 * 思路:
 *      1. 这种返回数组中第k个最大或者最小的数都是典型的  dk问题
 *
 *      2. 我们可以使用快速排序中的思想使用快速选择的方式来写,无论如何都是可以在数组中找到第k大或者第k小的数的
 *
 *      3. 我们可以使用优先队列来写,通过构建元素个数为k的大根堆或者是小根堆来实现(这里要注意需要懂堆排序的实现)
 */
public class _215_FindKthLargest {

    // 直接调库,不推荐
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    // 借用选择排序的方式,选择k个最大的数,返回最后一个选择的数
    public int findKthLargest2(int[] nums, int k) {

        int key = 0;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[key] < nums[j]) {
                    key = j;
                }
            }
            int temp = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = nums[key];
            nums[key] = temp;
            key = 0;
        }
        return nums[nums.length - k];

    }



    // 通过使用优先队列,构建一个元素个数为k的小顶堆(顶上的数在堆中最小),将大的数放在堆中,最后返回顶上的数即可
    public int findKthLargest3(int[] nums, int k) {

        // 我们这里使用的是小根堆,也是默认实现
        Queue<Integer> queue = new PriorityQueue<>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for(int i= 0;i<k;i++){
            queue.offer(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(queue.peek()<nums[i]){
                queue.poll();
                queue.offer(nums[i]);
            }
        }



        return queue.peek();
    }

    // 借助快速排序的思想,找到第k大的位置
    public int findKthLargest4(int[] nums, int k) {

        // 这里找到第k大的数,就是找到第nums.length - k 小的数
        // 因为我们这个process方法所做的事情就是找到第k小的数
        process(nums, 0, nums.length - 1, nums.length - k);


        return nums[nums.length - k];

    }

    private void process(int[] nums, int left, int right, int k) {
        if (left > right) {
            return;
        }

        int l = left;
        int r = right;


        /**
         * 建议每个快速排序都加入随机选择
         *
         *
         * 这里我们本可以直接选择最左边的数作为temp,但是我们这里用来随机选取,是因为这样性能更高
         *
         * 做法:
         *      在left和right范围内随机选择一个数和nums[left]做一个值交换
         *      之后我们继续以nums[left] 作为temp,进行比较,此时我们所用的就是我们随机选择出来的
         *      这个比我们直接将nums[left]作为temp更加高效
         *
         */
        int tempIndex = randomIndex(left, right);
        exchange(nums, tempIndex, left);

        int temp = nums[left];

        while (l < r) {
            while (l < r && nums[r] >= temp) {
                r--;
            }
            while (l < r && nums[l] <= temp) {
                l++;
            }

            if (l < r) {
                exchange(nums, l, r);
            }

        }
        exchange(nums, left, l);

        if (k < l) {
            process(nums, left, l - 1, k);
        }
        if (k > l) {
            process(nums, r + 1, right, k);
        }

    }

    private int randomIndex(int left, int right) {
        return new Random().nextInt(right - left + 1) + left; // 随机选一个作为我们的进行比较的元素
    }

    private void exchange(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }


}
