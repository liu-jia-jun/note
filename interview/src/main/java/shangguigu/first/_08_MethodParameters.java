package shangguigu.first;

import java.util.Arrays;

/**
 * @author 刘佳俊
 *
 * 方法参数的传递机制
 *      1. 参数是基本数据类型,就直接传递变量中的值,属于值传递
 *
 *      2. 参数是引用数据类型,传递的是该对象的地址值,属于址传递
 *          注意: String 类型 和 基本类型的包装类等对象有不可变性,也就是说,如果字符串传递之后,在方法中改变字符串内容,此时,字符串还是会
 *
 *
 */
public class _08_MethodParameters {
    public static void main(String[] args) {
        int i=1;
        String str = "hello";
        Integer num= 2;
        int[] arr = {1,2,3};
        Mydata mydata = new Mydata();
        change(i,str,num,arr,mydata);
        System.out.println("i="+i);
        System.out.println("str="+str);
        System.out.println("num="+num);
        System.out.println("arr="+ Arrays.toString(arr));
        System.out.println("my.a="+ mydata.a);

    }
    public static void change(int j,String s,Integer n,int[] a,Mydata mydata){
        j+=1;
        s+="world";
        n+=1;
        a[0] +=1;
        mydata.a+=1;
    }
}

class Mydata{
    int a= 10;
}