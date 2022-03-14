package algorithm.sort;

import algorithm.util.MyArray;

/**
 * @author 刘佳俊
 */
public class SelectiontSort {
    public static void main(String[] args) {
        int[] arr = MyArray.getUnorderedArray(15);
        int[] ints = selectiontSort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
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
