package lesson.primary;

import util.MyArray;

import java.util.Arrays;

/**
 * @author 刘佳俊
 *
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = MyArray.getUnorderedArray(20);

        int[] ints = bubbleSort(arr);
        System.out.println(Arrays.toString(ints));
    }


    public static int[] bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                }
            }
        }

        return arr;

    }


}
