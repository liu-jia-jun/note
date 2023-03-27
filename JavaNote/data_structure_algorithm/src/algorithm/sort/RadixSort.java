package algorithm.sort;

import algorithm.util.MyArray;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 刘佳俊
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = MyArray.getUnorderedArray(8000000);
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        radixSort(arr);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);


//        System.out.println(Arrays.toString(arr));


    }

    private static int[] radixSort(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        int len = (max + "").length();

        int[][] temp = new int[10][arr.length];

        int[] index = new int[10];
        int number;
        int n = 1;
        for (int i = 0; i < len; i++) {

            for (int j = 0; j < arr.length; j++) {
                number = arr[j] / n % 10;

                temp[number][index[number]] = arr[j];
                index[number]++;

            }
            n = n * 10;
            int arrIndex = 0;
            for (int k = 0; k < 10; k++) {
                for (int m = 0; m < index[k]; m++) {
                    arr[arrIndex] = temp[k][m];
                    arrIndex++;
                }
            }
            for (int l = 0; l < 10; l++) {
                index[l] = 0;
            }
        }


        return arr;
    }


}
