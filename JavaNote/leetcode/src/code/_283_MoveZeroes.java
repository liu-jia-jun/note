package code;

/**
 * @author 刘佳俊
 */
public class _283_MoveZeroes {
    public void moveZeroes(int[] nums){
        int i=0,j=-1;
        for(;i<nums.length;i++){
            if(nums[i]!=0){
                j++;
                nums[j]=nums[i];
            }
        }
        for(i=i-1;i>j;i--){
            nums[i]=0;
        }
    }
}
