package code;

import java.util.Arrays;

/**
 * @author 刘佳俊
 * 88. 合并两个有序数组
 */
public class _88_Merge {

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }


    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        int[] arr = new int[k];
        int i = 0;
        int j = 0;
        for (int index = 0; index < k; index++) {
            if (i >= m) {
                arr[index] = nums2[j++];
            } else if (j >= n) {
                arr[index] = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                arr[index] = nums1[i];
                i++;
            } else {
                arr[index] = nums2[j];
                j++;
            }
        }
        for (int x = 0; x < k; x++) {
            nums1[x] = arr[x];
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int k = n + m;
        for (int i = m - 1, j = n - 1, index = k - 1; index >= 0; index--) {
            if (i < 0) {
                nums1[index] = nums2[j--];
            } else if (j < 0) {
                nums1[index] = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                nums1[index] = nums1[i--];
            } else {
                nums1[index] = nums2[j--];
            }
        }
    }
}
