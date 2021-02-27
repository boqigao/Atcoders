package com.boqi.atcoders.abc.abc192;

import java.math.BigInteger;
import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);

    //测试
    public static void main(String[] args) {
        String x = sc.next();
        String m = sc.next();

        String m10 = m2n_constrait(10, m);
        int bigNum = 0;
        for (int i = 0; i < x.length(); i++){
            bigNum = Math.max(Integer.parseInt(x.charAt(i) + ""), bigNum);
        }

        int res = 0;
        for (int i = bigNum+1; i < Integer.MAX_VALUE; i++) {

            String xf = m2n_constrait(i, x);


            if (compare(xf, m10)) {
                res++;
            } else {
                break;
            }

        }

        System.out.println(res);

        //System.out.println(transRadix("15", 10, 2));
    }

    // x如果比m大，就是false
    // x如果比m小，就是true
    private static boolean compare(String x, String m) {
        if (x.length() > m.length()) {
            return false;
        }

        if (x.length() < m.length()) {
            return true;
        }

        boolean res = false;

        // 从高位开始比，如果一旦相同的位数，x的某一位大于m,那么这个时候x就比m大了
        // 如果前面位数都相等，但是某一个位数开始x比n大或者比n小，那么就不同了
        // 分类讨论，当x和m都
        for (int i = 0; i <x.length(); i++) {
            if (x.charAt(i) > m.charAt(i)) {
                return false;
            } else if (x.charAt(i)==m.charAt(i)) {
                continue;
            } else {
                return true;
            }
        }
        return true;
    }

    private  static String m2n_constrait(int srcBase, String srcNum){
        if (srcBase > 62 || srcBase < 2)
            return "";

        BigInteger midNum = new BigInteger("0");
        BigInteger srcBaseB = new BigInteger(srcBase+"");
        int temp = 0;
        for (int i = 0; i < srcNum.length();++i){
            if (srcNum.charAt(i) >= '0' && srcNum.charAt(i) <= '9')
                temp = srcNum.charAt(i) - '0';
            else if (srcNum.charAt(i) >= 'a' && srcNum.charAt(i) <= 'z')
                temp = srcNum.charAt(i) - 'a' + 10;
            else if (srcNum.charAt(i) >= 'A' && srcNum.charAt(i) <= 'Z')
                temp = srcNum.charAt(i) - 'A' + 36;
            else return "";
            midNum = midNum.multiply(srcBaseB);
            midNum = midNum.add(new BigInteger(temp + ""));
        }
        return midNum.toString();
    }
}
