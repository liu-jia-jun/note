package lesson.primary;

/**
 * @author 刘佳俊
 * <p>
 * 位运算
 */
public class BitOperation {

    public static void main(String[] args) {
        bitPrint(-1);
    }


    // 创建一个方式返回一个数的三十二位二进制
    public static void bitPrint(int number) {


        // 记录number某一位上的二进制是0还是1
        int n;

        for (int i = 31; i>=0; i--) {
            // 注意这里的与运算  和 对 1 进行的左移
            n = (number & (1 << i)) == 0 ? 0 : 1;
            System.out.print(n);
        }


    }


}
