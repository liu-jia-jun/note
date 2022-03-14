package algorithm.util;

/**
 * @author 刘佳俊
 */
public class MyArray {
    public static int[] getUnorderedArray(int n){
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=(int)(Math.random()*n);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        return array;
    }
}
