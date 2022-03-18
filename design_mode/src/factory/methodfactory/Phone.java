package factory.methodfactory;

/**
 * @author 刘佳俊
 */
public class Phone {
    String phoneName;
    public Phone(){}

    public Phone(String phoneName) {
        this.phoneName = phoneName;
    }

    void showPhone(){
        System.out.println("创建了"+this.phoneName+"手机");
    }
}
