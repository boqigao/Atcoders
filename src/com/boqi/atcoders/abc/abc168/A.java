package com.boqi.atcoders.abc.abc168;

import java.util.Scanner;

public class A {
    static Scanner sc =new Scanner(System.in);
    public static void main(String[] args) {
        String n = sc.next();
        if(n.charAt(n.length()-1) == '2'||
                n.charAt(n.length()-1) == '4'||
                n.charAt(n.length()-1) == '5'||
                n.charAt(n.length()-1) == '7'||
                n.charAt(n.length()-1) == '9'
        ) {
            System.out.println("hon");
        } else if (n.charAt(n.length()-1) == '0'||
                n.charAt(n.length()-1) == '1'||
                n.charAt(n.length()-1) == '6'||
                n.charAt(n.length()-1) == '8'){
            System.out.println("pon");
        } else {
            System.out.println("bon");
        }
    }
}
