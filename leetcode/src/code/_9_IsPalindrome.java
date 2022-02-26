package code;

/**
 * @author 刘佳俊
 *
 * 回文数字
 *
 */
public class _9_IsPalindrome {


    public boolean isPalindrome(int x) {



        String num = Integer.toString(x);
        if(x<0){
            return false;
        }
        int i =0;
        int j =num.length()-1;
        for(;i<j;){
            if(num.charAt(i)==num.charAt(j)){
                i++;
                j--;

            }else{
                return false;
            }
        }
        return true;


    }
}