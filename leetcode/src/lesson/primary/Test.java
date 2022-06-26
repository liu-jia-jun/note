package lesson.primary;

/**
 * @author 刘佳俊
 */
public class Test {
    public static void main(String[] args) {


        System.out.println(findNthDigit(99));
    }

    public static int findNthDigit(int n) {

        int sum = 0;
        int temp = 9;
        for (int i = 1; ; i++) {

            sum += i * temp;
            temp = temp * 10;
            if (n <= sum) {
                n = n - (sum - i * temp);
                temp = i;
                break;
            }
        }
        int num = n / temp;
        int m = n % temp;
        sum = 1;
        for (int i = 1; i <= temp; i++) {
            sum *= 10;
        }
        System.out.println(temp);
        System.out.println(sum);
        System.out.println(m);
        System.out.println(num);

        return m > 0 ? ("" + (sum + 1)).charAt(m - 1) : ("" + sum).charAt(temp - 1);
    }
}