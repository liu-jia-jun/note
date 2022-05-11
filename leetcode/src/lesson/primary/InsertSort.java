package lesson.primary;

import util.MyArray;

import java.util.Arrays;

/**
 * @author 刘佳俊
 * <p>
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = MyArray.getUnorderedArray(20);

        int[] ints = insertSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                } else {
                    break;
                }
            }
        }

        return arr;
    }

}
