package algorithm.search;

/**
 * @author 刘佳俊
 * 插值查找
 */
public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 99};
        System.out.println(interpolationSearch(arr, 2));
    }

    private static int interpolationSearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int middle;
        while (left <= right) {
            middle = left+(right-left)*(target-arr[left])/(arr[right]-arr[left]);
            if (target == arr[middle]) {
                return middle;
            } else if (target < arr[middle]) {
                right = middle - 1;
            } else if (target > arr[middle]) {
                left = middle + 1;
            }
        }
        return -1;
    }
}
