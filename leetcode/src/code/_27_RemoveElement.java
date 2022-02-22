package code;

/**
 * 移除元素
 *
 *
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @author 刘佳俊
 */
public class _27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int num=0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]==val){
                for(int j=i;j<len-1;j++){
                    nums[j]=nums[j+1];
                }
                // 这里需要注意末尾元素为val值导致重复计算，所以每次匹配并移动元素时都len--去掉最后一位元素
                len--;
                i--;
                num++;
            }
        }
        return nums.length - num;
    }
}
