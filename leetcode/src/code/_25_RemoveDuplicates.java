package code;

/**
 * @author 刘佳俊
 */
public class _25_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int len =nums.length;

        for(int i=0;i<len-1;){
            if(nums[i]==nums[i+1]){
                for(int j=i;j<len-1;j++){
                    nums[j]=nums[j+1];
                }
                len--;
            }else{
                i++;
            }
        }

        return len;
    }
}
