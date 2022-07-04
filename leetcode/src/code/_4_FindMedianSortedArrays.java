package code;

/**
 * @author 刘佳俊
 *
 * 寻找两个正序数组的中位数
 *
 * 思路:
 *
 *
 */
public class _4_FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int total = nums1.length + nums2.length;

        int mid = total / 2 - 1;

        int index1 = 0;
        int index2 = 0;


        while (mid > 0) {
            if (index1 >= nums1.length) {
                break;
            }
            if (index2 >= nums2.length) {
                break;
            }
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
            mid--;
        }



        if(mid>0){
           if(index1>= nums1.length){
               while (mid>0){
                   index2++;
               }
           }
            if(index2>= nums2.length){
                while (mid>0){
                    index1++;
                }
            }
        }


return 1;

    }
}
