package code;

/**
 * @author 刘佳俊
 */
public class _1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] index = new int[2];
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(target==(nums[i]+nums[j])){
                    index[0]=i;
                    index[1]=j;

                }
            }
        }
        return index;
    }
}