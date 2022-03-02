package code;

/**
 * @author 刘佳俊
 */
public class _0_Test {
    public static void main(String[] args) {
        _0_Test test = new _0_Test();
        int[] nums = new int[3];
        for(int i=0;i<3;i++){
            nums[i]=1;
        }
        System.out.println(test.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int k = len;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) {
                    for (int n = i; n < len - 1; n++) {
                        nums[n] = nums[n + 1];
                    }
                    len--;
                }
            }
        }
        return len;
    }
}
