package code;

/**
 * @author 刘佳俊
 */
public class _796_RotateString {
    public boolean rotateString(String s, String goal) {

        if(s.length()!=goal.length()){
            return false;
        }

        int len = s.length();
        s+=s;
        String temp ="";

        for(int i=0;i<len;i++){

            if(goal.charAt(0)==s.charAt(i)){
                temp = s.substring(i,i+len);
                if(goal.equals(temp)){
                    return true;
                }

            }

        }

        return false;

    }
}
