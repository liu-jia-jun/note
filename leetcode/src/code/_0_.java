package code;

/**
 * @author 刘佳俊
 */
public class _0_ {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        double result = 0;
        int i = nums1.length;
        int j = nums2.length;

        if (i == 0 && j == 0) {
            return result;
        }
        if (i == 0) {
            if (j % 2 == 0) {
                return nums2[j / 2];
            } else {
                return (nums2[j / 2] + nums2[(j / 2) - 1]) / 2.0;
            }
        }
        if (j == 0) {
            if (i % 2 == 0) {
                return nums2[i / 2];
            } else {
                return (nums2[i / 2] + nums2[(i / 2) - 1]) / 2.0;
            }
        }


        int amount = (i + j) / 2;

        i = 0;
        j = 0;


        for (int n = 0; n < amount; n++) {
            if(i<nums1.length&&j< nums2.length){
                if(nums1[i]<nums2[j]){
                    i++;
                }else{
                    j++;
                }
            }

            if(i>=nums1.length&&j< nums2.length){
                j++;
            }
            if(i<nums1.length&&j>= nums2.length){
                i++;
            }

        }

        if(amount%2==0){

        }else{
            if (i>=nums1.length){
                return nums2[j];
            }
            if(j>=nums1.length){
                return nums1[i];
            }

            if(i>j){
                return nums1[i];
            }else{
                return nums2[j];
            }

        }

    }
}
