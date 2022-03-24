package algorithm.sort;

import algorithm.util.MyArray;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author 刘佳俊
 * 插入排序
 *
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = MyArray.getUnorderedArray(1000000);
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        insertSort(arr);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
//        System.out.println(Arrays.toString(arr));
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
            array[j + 1] = temp;
        }
        return array;
    }
}