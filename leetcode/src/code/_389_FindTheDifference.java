package code;

/**
 * @author 刘佳俊
 *
 * 找不同:
 *      给定两个字符串 s 和 t ，它们只包含小写字母。
 *      字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *      请找出在 t 中被添加的字母。
 *
 *
 *  思路:
 *      1. 异或运算 找出 个数为奇数 或者 个数为 偶数的 元素
 *
 *      2. 通过题目我们可以知道 , t字符串中比s字符串多一个字符 其他的都相同
 *      3. 两个字符放在一起 就可以看成 有一个字符出现过 奇数次 其他字符出现过偶数次 找出这个奇数次 的字符
 *      4. 整体异或即可
 *
 */
public class _389_FindTheDifference {

    public static char findTheDifference(String s, String t) {

        char result = 0;

        for (char c : s.toCharArray()) {
            result ^= c;
        }
        for (char c : t.toCharArray()) {
            result ^= c;
        }
        return result;

    }
}
