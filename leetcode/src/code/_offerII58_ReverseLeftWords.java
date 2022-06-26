package code;

/**
 * @author 刘佳俊
 */
public class _offerII58_ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {

        int len = s.length();
        s +=s;
        return s.substring(n,len+n);
    }
}
