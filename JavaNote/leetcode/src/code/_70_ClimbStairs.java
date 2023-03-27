package code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘佳俊
 */
public class _70_ClimbStairs {

    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {

        int result;
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            if(null!=map.get(n)){
                return map.get(n);
            }else{
                result = climbStairs(n - 1) + climbStairs(n - 2);
                map.put(n,result);
                return  result;
            }

        }

    }

}