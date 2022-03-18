package factory.methodfactory;

/**
 * @author 刘佳俊
 */
public class DomesticPhone {
    void showPhone(String type) {
        System.out.println("这是国内手机");
        switch (type) {
            case "小米":
                new AbroadXMPhone("小米nova6").showPhone();
                break;
            case "华为":
                new AbroadXMPhone("华为").showPhone();
                break;
            default:
                System.out.println("创建错误");
        }
    }
}
