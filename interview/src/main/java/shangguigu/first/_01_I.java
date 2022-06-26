package shangguigu.first;

/**
 * @author 刘佳俊
 * <p>
 * 探究 i++ 与 ++i 区别
 *
 * i++ 是先运算后自增
 * ++i 是先自增后运算
 *
 * 注意 赋值操作是最后才进行的操作
 *
 * 注意 这里还需要清楚局部变量表和操作数栈的概念
 *
 */
public class _01_I {

    public static void main(String[] args) {


        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("k=" + k);

/*        int i = 1;
        i = i--;
        int j = i--;
        int k = i + --i * i--;
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("k=" + k);

       // k=1,j=1,i=-2
        */
    }


}
