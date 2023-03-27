package code;

/**
 * @author 刘佳俊
 *
 *
 * 寻找重复数
 *
 *
 * 思路1:
 *      1. 快慢指针法 , 数组成环 , 类比 链表成环
 *
 *      2. 使用快慢指针法 , 快指针一次走两步 , 慢指针一次走一步  题目中表明一定有重复的数 , 说明一定会成环
 *      3. 在快慢指针相遇的时候( 注意 我们这里使用的快慢指针相遇的 依据是 nums[fast] == nums[slow]) 就将 快指针指向开头 也就是下标为 0 的数组元素
 *      4. 之后 快指针和慢指针都一次走一步 快慢指针相遇的时候 就是称环的入口 , 返回即可
 *
 * 思路2:
 *      1. 创建一个和nums 同样大小的数组arr 并遍历nums 数组中的元素
 *      2. 将 nums 数组元素的值 作为 arr数组的下标 边遍历边改变 arr数组中对应下标的值
 *      3. 如果发现 arr 的某个数组元素已经被改变过的 , 那么这里这个数就是已经出现过的数 , 即重复数
 *
 */
public class _287_FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }


    public static int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        do {

            // 这里类比链表 是将数组元素的值作为一个节点的值
            // 并将这个数组元素的值作为next 域 指向 下一个元素( 这里指的是将这个值作为下一个元素的下标)
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (nums[fast] != nums[slow]);

        fast = 0;
        // 我们这里不能使用 fast != slow 因为会存在bug 这样是不能找到入环口的
        while (nums[fast] != nums[slow]) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return nums[fast];

    }

    public static int findDuplicate2(int[] nums) {
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (arr[nums[i]] == 1) {
                return nums[i];
            }
            arr[nums[i]] = 1;
        }
        return -1;
    }
}
