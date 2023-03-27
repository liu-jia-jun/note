package code;

import java.util.*;

/**
 * @author 刘佳俊
 *
 * 滑动窗口最大值 :
 *  给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 每次滑动窗口中的最大值 组成一个数组返回 。
 *
 *
 *  思路:
 *       1. 优先队列 (大顶堆)
 *       2. 使用优先队列 维护一个 的大顶堆
 *       3. 依次遍历 k-1 个数组元素  并直接加入到优先队列 此时 这些元素的个数 小于 k 个 不足以构成滑动窗口 所以这里不能产生窗口最大值
 *       4. 当我们 遍历到 第k个元素时 构成了滑动窗口 这个时候 我们就要 取出最大值 但是 取出最大值 之前 我们要判断这个最大值的下标是否过期
 *       5. 下标过期 : 因为我们找的是滑动窗口中的最大值 如果大顶堆的最大值的下标 已经超出了滑动窗口的下标 那么我们就要移除大顶堆中的最大值
 *              判断下一个最大值 的下标是否过期 如果过期 则重复 第五步 如果没有过期 那么我们就就将 该最大值的 加入到 result 数组中
 *       6. 当我们将数组遍历完全 此时我们就得到了一个 完整的数组 直接返回即可
 *       7. 注意 : 我们在优先队列中
 *              要根据 数组元素的值来排序 也要根据 数组元素的下标 来判断 该元素是否过期 所以我们这里使用的是一个小数组来存储这两个值
 *
 *
 *       =====================================================================================
 *
 *       1. 单调队列 (即创建一个双端队列 并维持这个队列是单调递增 或者单调递减 )
 *       2. 我们创建一个 双端队列 (我们有时候要操作头部元素 有时候要操作尾部元素 所以是双端队列) 之后 直接遍历这个数组
 *       3. 当我们遍历到 下标为 i 的元素时
 *             1) 当队列为空时直接将该元素入队列
 *             2) 当队列不为空时
 *                  当 nums[i] > 队尾元素时 将队尾元素出队 之后再走 第一步 1)
 *                  当 nums[i] <= 队尾元素时 将直接将 该元素入队列
 *
 *        4. 遍历完该元素时 我们要考虑是否要取出最大值 如果 (i+1)>=k 就证明 此时遍历的元素数量已经大于等于 滑动窗口大小此时已经产生了 最大值
 *        5. 产生最大值之后 根据上述的入队规则 队头是最大值 队尾是最小值
 *              1). 我们要判断 队列头的最大值的下标是否过期( 即 i 元素 到 队列最大值的下标 是否超过了滑动窗口的大小)
 *              2). (i-queue.getFirst()+1)>k 这样就是 下标过期 此时我们要将队头 元素出队列 之后再走第五步 5.
 *              3). 如果队列头的最大值的下标没有 过期 那我们 直接将队头元素的 加入到 需要返回的数组中 ( 此时队头元素并不需要出队列)
 *
 *
 */
public class _239_MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums ={7,2,4};

        int[] ints = maxSlidingWindow(nums, 2);
        System.out.println(Arrays.toString(ints));
    }


    // 单调队列
    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null) {
            return null;
        }
        if (k == 1) {
            return nums;
        }
        int len = nums.length;
        int[] result = new int[len - k + 1];
        int index = 0;

        LinkedList<Integer> queue = new LinkedList<>();


        for (int i = 0; i < len; i++) {

            while(!queue.isEmpty()&&nums[queue.getLast()]<=nums[i]){
                queue.removeLast();
            }
            queue.add(i);

            // 判断队列最左端下标(最大值)是否过期 , 如果过期则移除
            while ((i-queue.getFirst()+1)>k){
                queue.removeFirst();
            }

            if((i+1)>=k){
                result[index++] = nums[queue.getFirst()];
            }
        }
        return result;
    }

    // 优先队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null) {
            return null;
        }
        if (k == 1) {
            return nums;
        }

        int len = nums.length;
        int[] result = new int[len - k + 1];
        int index = 0;

        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

        for (int i = 0; i < k - 1; i++) {
            queue.add(new int[]{nums[i], i});
        }

        for (int i = k - 1; i < len; i++) {
            queue.add(new int[]{nums[i], i});
            while ((i - queue.peek()[1] + 1) > k) {
                queue.remove();
            }
            result[index++] = queue.peek()[0];
        }


        return result;
    }
}
