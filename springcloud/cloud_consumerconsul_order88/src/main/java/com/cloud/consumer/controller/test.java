package com.cloud.consumer.controller;

import java.util.Scanner;

/**
 * @author 刘佳俊
 */
public class test {
    public static void main(String[] args) {
        // 创建输入方法，相当于scanf()
        Scanner scanner = new Scanner(System.in);
        float gongli = scanner.nextFloat();// 这里的gongli 就是我们从控制台输入的值

        double result;// 结果，就是我们需要输出的数字
        if (gongli <= 2) {
            result = 7;
        } else if (gongli > 2 && gongli <= 15) {
            if (gongli > (int) gongli) {
                gongli = (int)gongli + 1;
            }
            result = 7 + (gongli - 2) * 1.5;
        } else {
            if (gongli > (int) gongli) {
                gongli = (int)gongli + 1;
            }
            result = 7 + (gongli - 2) * 2.1;
        }
        // 这里是输出语句，相当于我们的printf()语句
        System.out.println(result);
    }
}
