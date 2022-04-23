package algorithm.sort;

import java.util.Arrays;

/**
 * @author 刘佳俊
 * <p>
 * 堆排序
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] arr = {2, 10, 8, 22, 34, 5, 12, 28, 21, 11};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {

        // 将无序序列构建成一个大顶堆，根据升序降序需求选择大顶堆或小顶堆
        // 注意,我们这里依次从最后的非叶子节点的元素比较过来,所以通过本次循环可以得到一个完成的大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        int temp;


        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            // 注意这里再次进行大顶堆的构建是因为我们在互换了第一个和最后一个元素的值时,我们已经破坏了这个大顶堆,所以我们需要重新构建这个大顶堆
            // 但是这个破坏的大顶堆的内部还是保持稳定的结构,所以,我们可以只是通过一次0这个节点的构建,就可以重塑这个大顶堆
            adjustHeap(arr, 0, j);
        }


    }

    // 给定一个节点进行构建大顶堆
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        // 因为我们给的节点的下面可能还会有非叶子节点所以我们需要使用for循环
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 通过比较给定节点的左右子节点的大小使得k指向较大的一个节点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k = k + 1;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;// 使得对他的子树再进行构建大顶堆
            } else {
                // 这里可以直接跳出循环是因为我们最开始是从最后一个非叶子节点开始比较的,经过完整构建大顶堆之后
                // 下面的值应该是小于上面的值的,如果arr[k]<temp的话就说明下面的值都小于temp就可以直接break退出了
                break;
            }
        }
        // 当 for 循环结束后，我们已经将以 i 为父结点的树的最大值，放在了 最顶(局部树)
        arr[i] = temp;//将 temp 值放到调整后的位置
    }
}
