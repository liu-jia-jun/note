package code;

/**
 * @author 刘佳俊
 */
public class _191_HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {


        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n & (1 << i)) == 0 ? 0 : 1;
        }

        return count;

    }
}
