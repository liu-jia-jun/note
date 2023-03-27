package data_structure.tree;

/**
 * @author 刘佳俊
 */
public class ArrBinaryTreeDemo {

    private int[] arr={1,2,3,4,5,6,7,8,9};

    public static void main(String[] args) {
        ArrBinaryTreeDemo demo = new ArrBinaryTreeDemo();
        demo.pre();
    }

    void pre(){
        if(arr==null||arr.length<1){
            System.out.println("数组为空");
        }else{
            this.preOrder(0, arr.length);
        }
    }

    public  void preOrder(int index,int len) {
        System.out.println(arr[index]);
        if(2*index+1< len){
            preOrder(2*index+1,len);
        }
        if(2*index+2< len){
            preOrder(2*index+2,len);
        }
    }


}
