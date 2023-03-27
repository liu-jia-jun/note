package algorithm.sort;

import algorithm.util.MyArray;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 刘佳俊
 * 快速排序
 */
public class QuickSort {

    private static int[] arr;

    public static void main(String[] args) {
        arr = MyArray.getUnorderedArray(20);
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
        quickSort(arr, 0, arr.length - 1);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int temp = arr[begin];
        int i = begin;
        int j = end;
        while (i < j) {
            while (arr[j] >= temp && j > i) {
                j--;
            }
            arr[i] = arr[j];
            while (arr[i] < temp && j > i) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = temp;
        quickSort(arr, begin, i - 1);
        quickSort(arr, i + 1, end);
    }
}
