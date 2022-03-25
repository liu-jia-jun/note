package algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘佳俊
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 99};
        System.out.println(biarySearch2(arr, 9));
    }

    private static int biarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
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

    private static List<Integer> biarySearch2(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int middle;
        List<Integer> list = new ArrayList<>();
        while (left <= right) {
            middle = (left + right) / 2;
            if (target == arr[middle]) {
                list.add(middle);
                int i = middle - 1, j = middle + 1;
                while (i >= left) {
                    if (arr[i] == target) {
                        list.add(i);
                        i--;
                    }else{
                        break;
                    }

                }
                while (j <= right) {
                    if (arr[j] == target) {
                        list.add(j);
                        j++;
                    }else {
                        break;
                    }
                }
                return list;
            } else if (target < arr[middle]) {
                right = middle - 1;
            } else if (target > arr[middle]) {
                left = middle + 1;
            }
        }
        return list;
    }
}
