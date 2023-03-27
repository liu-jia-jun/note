package code;

/**
 * @author 刘佳俊
 */
public class _521_FindLUSlength {
    public int findLUSlength(String a, String b) {
        return !a.equals(b)?(Math.max(a.length(),b.length())):-1;

    }
}
