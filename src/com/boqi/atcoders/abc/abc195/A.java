package com.boqi.atcoders.abc.abc195;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int m = sc.nextInt();
        int h = sc.nextInt();

        System.out.println(h % m == 0?"Yes":"No");
    }
}
