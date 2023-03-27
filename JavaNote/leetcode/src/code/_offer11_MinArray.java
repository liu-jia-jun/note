package code;

/**
 * @author 刘佳俊
 */
public class _offer11_MinArray {


    public int minArray(int[] numbers) {

        int result = numbers[0];
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] > numbers[(i + 1) % numbers.length]) {
                result = numbers[(i + 1) % numbers.length];
                break;
            }
        }
        return result;
    }
}
