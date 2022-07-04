package code;

import java.util.ArrayList;
import java.util.List;

/**Z 字形变换
 * @author asus
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下

 */
public class _6_ZigZagConversion {

    public String convert(String s, int numRows) {

        /**
         对于n行的, s中的第i个字符：
         1534236469
         2147483648
         对余数进行判断

         i%(2n-2) == 0 ----> row0

         i%(2n-2) == 1 & 2n-2-1 ----> row1

         i%(2n-2) == 2 & 2n-2-2 ----> row2

         ...

         i%(2n-2) == n-1 ----> row(n-1)

         ==>

         对 k = i%(2n-2)进行判断

         k<=n-1时候，s[i]就属于第k行
         k>n-1时候，s[i]就属于2n-2-k行
         最后将rows拼接起来就行了
         */
        String[] strs = new String[numRows];

        int len = s.length();
        int k;
        if (len == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < len; i++) {
            k = i == 0 ? 0 : i % (2 * numRows - 2);

            if (k <= numRows - 1) {
                strs[k] = strs[k] == null ? "" : strs[k];
                strs[k] += s.charAt(i);

            } else {// 这里判断该元素属于2n-2-k 行
                strs[2 * numRows - 2 - k] = strs[2 * numRows - 2 - k] == null ? "" : strs[2 * numRows - 2 - k];
                strs[2 * numRows - 2 - k] += s.charAt(i);
            }
        }
        String string = "";
        for (String str : strs) {
            str = str == null ? "" : str;
            string += str;
        }
        return string;
    }
}