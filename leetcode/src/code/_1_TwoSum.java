package code;

import java.util.HashMap;
import java.util.Map;

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
    public int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        Integer index;
        for(int i=0;i<nums.length;i++){
            index =(map.get(target-nums[i]));
            if( index!=null){
                result[0]=index;
                result[1]=i;
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return result;
    }
}