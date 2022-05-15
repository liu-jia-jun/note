package util;

/**
 * @author 刘佳俊
 */
public class MyArray {
    // 返回n 个 从 1 到 n 的 随机数
    public static int[] getUnorderedArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * n + 1);
        }
        return array;
    }

    // 返回number 个 从 1 到 n 的 随机数
    public static int[] getUnorderedArrayInNumber(int number,int n) {
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = (int) (Math.random() * n + 1);
        }
        return array;
    }
}
