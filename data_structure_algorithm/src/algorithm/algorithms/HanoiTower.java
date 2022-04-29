package algorithm.algorithms;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

/**
 * @author 刘佳俊
 */
public class HanoiTower {
    static int count=0;
    public static void main(String[] args) {
        hanoiTower(2,'A','B','C');
        System.out.println(count);
        hanoiTower(3,'A','B','C');

    }

    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘中从" + a + "->" + c);
        } else {
            // 如果我们有 n>=2的情况,我们都将看做两个盘子,最下面的一个,和上面的盘子,拢共两个
            // 1. 我们先把最上面的所有盘子从A -> B,移动的过程中会用到c
            hanoiTower(num - 1, a, c, b);
            // 2. 把最下面的盘从 A -> C
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            // 3. 把B塔的所有盘从 B -> C ,移动过程中用到 a塔
            hanoiTower(num-1,b,a,c);
        }
        count++;
    }
}
