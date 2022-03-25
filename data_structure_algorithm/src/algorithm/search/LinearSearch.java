package algorithm.search;

/**
 * @author 刘佳俊
 * 线性查找
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(linearSearch(arr, 4));
    }
    public static int linearSearch(int[] arr,int target){

        int index=-1;
        for (int i = 0; i < arr.length; i++) {
            if(target==arr[i]){
                index=i;
                return index;
            }
        }
        return index;

    }
}
