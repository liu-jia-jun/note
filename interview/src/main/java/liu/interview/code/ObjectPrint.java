package liu.interview.code;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author 刘佳俊
 */
public class ObjectPrint {
    public static void main(String[] args) {
        CommonTestBean commonTestBean = new CommonTestBean();
        System.out.println(ClassLayout.parseInstance(commonTestBean).toPrintable());
    }
}
