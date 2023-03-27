package algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘佳俊
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 99};
        // 返回下标
        System.out.println(binarySearch(arr, 9));
        System.out.println(binarySearchByRecursion(0, arr.length, 9, arr));
    }

    private static int binarySearch(int[] arr, int target) {
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

    // 返回查找到的所有的目标值的下标并以数组的形式返回
    private static List<Integer> binarySearchAll(int[] arr, int target) {
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
                    } else {
                        break;
                    }

                }
                while (j <= right) {
                    if (arr[j] == target) {
                        list.add(j);
                        j++;
                    } else {
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

    public static List<Integer> binarySearchByRecursionAll(int left, int right, int target, int[] arr, List<Integer> list) {
        if (left > right) {
            list.add(-1);
            return list;
        }
        int middle = (left + right) / 2;
        if (arr[middle] == target) {
            list.add(middle);
            int i = middle - 1, j = middle + 1;
            while (i >= left) {
                if (arr[i] == target) {
                    list.add(i);
                    i--;
                } else {
                    break;
                }

            }
            while (j <= right) {
                if (arr[j] == target) {
                    list.add(j);
                    j++;
                } else {
                    break;
                }
            }
            return list;
        } else if (arr[middle] > target) {
            return binarySearchByRecursionAll(left, middle - 1, target, arr, list);
        } else {
            return binarySearchByRecursionAll(middle + 1, right, target, arr, list);
        }
    }

    public static int binarySearchByRecursion(int left, int right, int target, int[] arr) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (arr[middle] == target) {
            return middle;
        } else if (arr[middle] > target) {
            return binarySearchByRecursion(left, middle - 1, target, arr);
        } else {
            return binarySearchByRecursion(middle + 1, right, target, arr);
        }

    }


}
