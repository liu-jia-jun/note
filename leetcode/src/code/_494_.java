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
        int n = nums.length;
        int s = 0;
        for (int i : nums) {
            s += Math.abs(i);
        }
        if (Math.abs(target) > s) {
            return 0;
        }


        int[][] f = new int[n + 1][2 * s + 1];
        f[0][0 + s] = 1;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = -s; j <= s; j++) {
                if ((j - x) + s >= 0) {
                    f[i][j + s] += f[i - 1][(j - x) + s];
                }
                if ((j + x) + s <= 2 * s) {
                    f[i][j + s] += f[i - 1][(j + x) + s];
                }
            }
        }
        return f[n][target + s];
    }





    // 暴力递归
    public int findTargetSumWays2(int[] nums, int target) {
        return process2(nums, 0, target);
    }

    public int process2(int[] nums, int index, int target) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        return process2(nums, index + 1, target - nums[index]) + process2(nums, index + 1, target + nums[index]);
    }


    // 暴力递归 + 记忆化搜索
    public int findTargetSumWays3(int[] nums, int target) {

        Map<String, Integer> map = new HashMap<>();
        return process3(nums, 0, target, map);
    }

    public int process3(int[] nums, int index, int target, Map<String, Integer> map) {
        String key = index + "_" + target;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (index == nums.length) {
            int result = target == 0 ? 1 : 0;
            map.put(key, result);
            return result;
        }
        int left = process3(nums, index + 1, target - nums[index], map);

        int right = process3(nums, index + 1, target + nums[index], map);

        map.put(key, left + right);
        return left + right;
    }
}
