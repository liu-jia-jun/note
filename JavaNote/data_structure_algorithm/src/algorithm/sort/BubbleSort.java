package algorithm.sort;

import algorithm.util.MyArray;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 刘佳俊
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = MyArray.getUnorderedArray(8);
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        bubbleSort(arr);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] bubbleSort(int[] arr) {

        int temp = 0;
        // 设置一个变量，当遇到遍历时没有一次元素互换时，就证明该数组已经排序完成，可以退出循环
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag == true) {
                // 优化，当有一次的循环中没有一次元素的互换就认为元素排序完成
                break;
            } else {
                flag = true;
            }
        }

        return arr;
    }

}
