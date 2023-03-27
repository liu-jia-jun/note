package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 刘佳俊
 */
public class T {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int result = -1;
        for (int i =(a>b?a:b); i <=(a*b); i++) {
            if(i%b==0&&i%a==0){
                result = i;
            }
        }
        System.out.println(result);
    }
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = in.nextInt();
//        }
//        int ans = 0;
////        for (int i = n - 1; i > 0; i--) {
////            for (int j = i - 1; j >= 0; j--) {
////                if(arr[i]>=arr[j]){
////                    ans+=arr[j];
////                }
////            }
////        }
//
//        int num =0 ;
//        for (int i = 0; i <n ; i++) {
//            for (int j = i+1; j <n ; j++) {
//                if(arr[i]<=arr[j]){
//                    num++;
//                }
//            }
//            ans += num*arr[i];
//            if(ans>1000000007){
//                ans %= 1000000007;
//            }
//            num=0;
//        }
//
//
//
//        System.out.println(ans);
//
//
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//
////        String[] s1 = s.split(" ");
//        String s1 = s.trim();
//        char[] chars = s1.toCharArray();
//        int ans =0 ;
//        for(int i= chars.length-1;i>=0;i--){
//            if(" ".equals(chars[i])){
//                break;
//            }
//            ans++;
//        }
//        System.out.println(ans);
//
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        int ans =0 ;
//        for (char c : s.toCharArray()) {
//            if((int)c>=65&&(int)c<=90){
//                ans++;
//            }
//        }
//        System.out.println(ans);
//
//    }
}
