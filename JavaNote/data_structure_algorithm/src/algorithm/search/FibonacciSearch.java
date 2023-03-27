package algorithm.search;

/**
 * @author 刘佳俊
 *
 * 斐波那契查找
 *
 * 请注意：这里的斐波那契数列中的值指的是数字元素的个数而不是下标，这也就是为什么在向右查找时是k-=2，k-=2指的是向右查找时数组右边元素的个数
 * 之后再在剩余个数的元素中重复使用斐波那契查找
 *
 *
 */
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println("index=" +  fibonacciSearch(arr, 1));



    }


    /**
     * 得到一个斐波那契数列
     * @return
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    private static int fibonacciSearch(int[] arr, int target) {

        int left=0;
        int mid;
        int right=arr.length-1;
        int k=0;// 这个k是用于指向斐波那契数列的下标的
        int[] fib = fib();
        while(arr.length>fib[k]){
            k++;
        }
        int[] temp = new int[fib[k]];
        for(int i=0;i< temp.length;i++){
            if(i>right){
                temp[i]=arr[right];
            }else{
                temp[i]=arr[i];
            }
        }


        while(right>=left){
            mid=left+fib[k-1]-1;
            if(target<temp[mid]){
                right=mid-1;
                k--;
            }else if(target>temp[mid]){
                left=mid+1;
                k-=2;
            }else{
                if(mid>= arr.length){
                    return arr.length-1;
                }else{
                    return mid;
                }
            }
        }




        return -1;
    }
}
