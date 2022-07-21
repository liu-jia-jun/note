package code;

/**
 * @author 刘佳俊
 */
public class _3_ {


    public static void main(String[] args) {

    }

    public  int lengthOfLongestSubstring(String s) {
        int max = 1;
        int index = 0;
        char[] str = s.toCharArray();
        for (int i = 1; i < str.length; i++) {
            for (int j = i - 1; j >= index; j--) {
                if (str[i] == str[j]){
                    index=j;
                    max = (i-index)>max?(i-index):max;

                }
                max = (i-index)>max?(i-index):max;
            }
        }
        return max;
    }
}
