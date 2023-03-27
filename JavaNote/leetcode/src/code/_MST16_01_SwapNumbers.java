package code;

/**
 * @author 刘佳俊
 *
 * 交换数字: 不使用其他变量交换两个变量中的数字
 *
 * 思路:
 *      1. 通过两数相加相减 或者 异或操作 进行交换两数
 *      2. 加减法
 *          a = a + b;    a = a+b
 *          b = a+b - b;  b = a
 *          a = a+b - b 相当于 a = a+b -a ;  a = b
 *
 *      3. 异或法: 不同为1 相同为0
 *          异或相当于无进位相加
 *          两个相同的数异或等于0  一个数和0 异或是本身
 *
 *          a = a ^ b; a = a^b
 *          b = a^b ^ b; b = a
 *          a = a^b ^ a; a = b
 *
 *
 */
public class _MST16_01_SwapNumbers {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }

    public int[] swapNumbers2(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}
