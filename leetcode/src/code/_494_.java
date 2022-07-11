package code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘佳俊
 */
public class _494_ {


    // 动态规划
    public int findTargetSumWays(int[] nums, int target) {

        int[][] dp = new int[nums.length][target];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i <; i++) {
            for (int j = 0; j <; j++) {

            }
        }






    }





    // 暴力递归
    public int findTargetSumWays2(int[] nums, int target) {
        return process2(nums,0,target);
    }

    public int process2(int[] nums,int index,int target){
        if(index==nums.length){
            return target==0?1:0;
        }
        return process2(nums,index+1,target-nums[index])+process2(nums,index+1,target+nums[index]);
    }


    // 暴力递归 + 记忆化搜索
    public int findTargetSumWays3(int[] nums, int target) {

        Map<String,Integer> map = new HashMap<>();
        return process3(nums,0,target,map);
    }

    public int process3(int[] nums,int index,int target,Map<String,Integer> map){
        String key = index + "_" + target;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(index==nums.length){
            int result = target==0?1:0;
            map.put(key,result);
            return  result;
        }
        int left = process3(nums,index+1,target-nums[index],map);

        int right =process3(nums,index+1,target+nums[index],map);

        map.put(key,left+right);
        return left+right;
    }
}
