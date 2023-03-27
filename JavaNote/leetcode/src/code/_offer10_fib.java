package code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘佳俊
 * map,存储已经计算出来的结果，每次递归之前查询是否有结果，如果有直接返回，如果没有继续递归
 * 达到减少计算次数的效果
 */
public class _offer10_fib {

    Map<Integer,Integer> map = new HashMap<>();
    public int fib(int n) {
        int result;
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            if(null==map.get(n)){
                result = fib(n-1) +fib(n-2);
                map.put(n,result);
                return result%1000000007;
            }else{
                return map.get(n)%1000000007;
            }

        }

    }
}
