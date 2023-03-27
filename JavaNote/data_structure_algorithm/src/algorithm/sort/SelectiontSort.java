package algorithm.sort;

import algorithm.util.MyArray;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 刘佳俊
 * 选择排序
 */
public class SelectiontSort {
    public static void main(String[] args) {
        int[] arr = MyArray.getUnorderedArray(80000);
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        selectiontSort(arr);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
    }
    public static int[] selectiontSort(int[] array){

        int max=0;
        int temp=0;
        for (int i = 0; i < array.length; i++) {
            max=0;
            for (int j = 0; j < array.length-i; j++) {
                if (array[j]>array[max]){
                    max=j;
                }
            }
            temp=array[max];
            array[max]=array[array.length-1-i];
            array[array.length-1-i]=temp;
        }




        return array;
    }
}
