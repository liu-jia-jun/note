package code;

/**
 * @author 刘佳俊
 */
public class _MST17_14_SmallestK {
    public int[] smallestK(int[] arr, int k) {

        if (arr == null || k == 0) {
            return new int[0];
        }
        poccess(arr, 0, arr.length - 1, k);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;

    }

    private void poccess(int[] arr, int left, int right, int k) {
        if (left > right) {
            return;
        }
        int l = left;
        int r = right;
        int temp = arr[left];

        while (l < r) {
            while (l < r && arr[r] >= temp) {
                r--;
            }
            while (l < r && arr[l] <= temp) {
                l++;
            }

            if (l < r) {
                exchange(arr, l, r);
            }
        }
        exchange(arr, l, left);

        if (l > k) {
            poccess(arr, left, l - 1, k);
        }
        if (l < k) {
            poccess(arr, r + 1, right, k);
        }

    }

    private void exchange(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}
