package algorithm.sort;

import algorithm.util.MyArray;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 刘佳俊
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = MyArray.getUnorderedArray(1000000);
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        shellSort(arr);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

//        System.out.println(Arrays.toString(arr));
    }

    public static int[] shellSort(int[] array) {

        int temp;
        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < array.length; i += 1) {
                temp = array[i];
                int j;
                for (j = i - gap; j >= 0 && array[j] > temp; j -= gap) {
                    array[j + gap] = array[j];
                }
                array[j + gap] = temp;
            }
        }

        return array;
    }


}
