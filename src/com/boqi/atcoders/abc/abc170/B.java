package com.boqi.atcoders.abc.abc170;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int x = sc.nextInt();//头数量
        int y = sc.nextInt();//脚数量
        boolean flag = false;
        for(int i = 0; i <= x; i++){//i是二脚动物的数量
            if ((x-i)*4+i*2==y) {
                flag = true;
                break;
            }
        }

        System.out.println(flag?"Yes":"No");
    }
}
