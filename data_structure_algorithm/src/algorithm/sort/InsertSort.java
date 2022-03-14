package algorithm.sort;

import algorithm.util.MyArray;


/**
 * @author 刘佳俊
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = MyArray.getUnorderedArray(15);
        int[] ints = insertSort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] insertSort(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                // 每每遇到比temp大的数就向后移动一位，直到遇到比temp小的数，即找到了插入的位置
                array[j + 1] = array[j];
            }
            array[j+1] = temp;
        }
        return array;
    }
}