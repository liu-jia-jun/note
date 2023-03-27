package book;

import util.MyArray;

import java.util.LinkedList;

/**
 * @author 刘佳俊
 *
 * 最大值减去最小值 小于或者等于num 的子数组的数量
 *
 *
 * 思路:
 *      1. 单调队列维护最大最小值
 *
 *
 */
public class GetSunOfArrayNumber {
    public static void main(String[] args) {
        int[] arr = MyArray.getUnorderedArrayInNumber(100, 100);

        for (int i = 0; i < 1000; i++) {

            int number = getNumber(arr, i);
            int numberInBook = getNumberInBook(arr, i);

            if (number != numberInBook) {
                System.out.println("error");
                break;
            }
        }


    }

    public static int getNumberInBook(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (num == 0) {
            return arr.length;
        }

        LinkedList<Integer> qMax = new LinkedList<>();
        LinkedList<Integer> qMin = new LinkedList<>();
        int i = 0, j = 0, res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[j]) {
                    qMin.pollLast();
                }
                qMin.addLast(j);

                while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[j]) {
                    qMax.pollLast();
                }
                qMax.addLast(j);


                if (arr[qMax.getFirst()] - arr[qMin.getFirst()] > num) {
                    break;
                }
                j++;

            }
            if (qMin.peekFirst() == i) {
                qMin.pollFirst();
            }
            if (qMax.peekFirst() == i) {
                qMax.pollFirst();
            }

            res += (j - i);
            i++;
        }
        return res;
    }

    public static int getNumber(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (num == 0) {
            return arr.length;
        }
        int result = 0;

        LinkedList<Integer> qMax = new LinkedList<>();
        LinkedList<Integer> qMin = new LinkedList<>();
        int i = 0, j = 0;

        for (; i < arr.length; i++) {
            for (; j < arr.length; j++) {
                while (!qMax.isEmpty() && arr[qMax.getLast()] <= arr[j]) {
                    qMax.removeLast();
                }
                qMax.addLast(j);

                while (!qMin.isEmpty() && arr[qMin.getLast()] >= arr[j]) {
                    qMin.removeLast();
                }
                qMin.addLast(j);


                if ((arr[qMax.getFirst()] - arr[qMin.getFirst()])> num) {
                    break;
                }
            }

            if (qMax.getFirst() == i) {
                qMax.removeFirst();
            }
            if (qMin.getFirst() == i) {
                qMin.removeFirst();
            }
            result += (j - i);
        }

        return result;
    }
}
