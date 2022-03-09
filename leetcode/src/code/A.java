package code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘佳俊
 */
public class A {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int temp;
        for(int i=0;i<nums.length;i++){
            if(0<nums[i]&&nums[i]<=nums.length){
                nums[nums[i]]+=nums.length;
            }else{
                temp = nums[i]-nums.length;
                nums[nums[temp]]+=nums.length;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(0<nums[i]&&nums[i]<=nums.length){
                list.add(i);
            }
        }
        return list;
    }
}
