package code;

/**
 * @author 刘佳俊
 *
 * 拿硬币
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 *
 *
 * 思路:
 *      1. 本题为简单题,但是这里有我们可以借鉴的点
 *      2. 乘除法我们可以通过位运算来进行,这样的方式更加快捷
 *
 */
public class _LCP06_MinCount {
    public int minCount(int[] coins) {

        int count = 0;
        for(int i=0;i<coins.length;i++){
            count += coins[i]%2==0?coins[i]>>2:(coins[i]>>2 +1);
        }
        return count;

    }
}
