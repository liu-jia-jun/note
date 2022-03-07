package algorithm;

/**
 * @author 刘佳俊
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[4];
        arr[0] = 15;
        arr[1] = 116;
        arr[2] = 48;
        arr[3] = 618;
        int[] ints = bubbleSort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

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
                System.out.println("退出");
                break;
            } else {
                flag = true;
            }
        }

        return arr;
    }

}
