package code;

/**
 * @author 刘佳俊
 *  数组异或操作:
 *              给你两个整数，n 和 start 。
 *
 *              数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 *
 *              请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 *
 *  思路1:
 *      1. 模拟 直接根据题意 转换成代码 直接输出
 *      2. 时间复杂度 为 O(n)
 *
 *  思路2:
 *      1. 找规律 时间复杂度 O(1)
 *
 *
 */
public class _1486_ {
    public static void main(String[] args) {

    }
    public int xorOperation(int n, int start) {

        int result = 0;
        for(int i=0;i<n;i++){
            result ^= (start + 2*i);
        }
        return result;

    }
    public int xorOperation2(int n, int start) {
        if(n%4==0){
            return start;
        }else if(n%4==1){
            return  start^(2*(n-1));
        }else if(n%4==2){
            return  start^(2*(n-1))^(2*(n-2));
        }else{
            return  start^(2*(n-1))^(2*(n-2))^(2*(n-3));
        }
    }
}
