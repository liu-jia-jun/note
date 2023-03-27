package code;

/**
 * @author 刘佳俊
 */
public class Test {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;
        Integer f1 =100 , f2=100 , f3 =150 , f4 =150;
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a.equals(b));
        System.out.println(f1==f2);
        System.out.println(f3==f4);
    }
    public String test(){
        try{
            System.out.println("try");
            return "return";
        }catch (Exception e){

        }finally {
            System.out.println("finally");
        }
        return null;
    }
    public void test2(){
        String result = test();
        System.out.println(result);
    }
}
