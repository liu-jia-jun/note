package lesson.primary;

import com.sun.deploy.util.ArrayUtil;
import util.MyArray;

import java.util.Arrays;

/**
 * @author 刘佳俊
 *
 * 选择排序
 */
public class SelectSort {


    public static void main(String[] args) {


        int[] arr = MyArray.getUnorderedArray(20);

        int[] ints = selectSort(arr);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] selectSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
