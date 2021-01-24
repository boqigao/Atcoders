package com.boqi.atcoders.companies.hitachi20200308;

import java.util.Scanner;
import java.util.Stack;

public class HitachiString {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        test("hihiii");
    }

    static void test(String s) {
        //String s = sc.next();
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        if (s.length() == 1) {
            System.out.println("No");
        } else if (s.length() == 2) {
            if (s.charAt(0) == 'h' && s.charAt(1) == 'i') {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } else {
            while ((index = s.indexOf("hi", index)) != -1
                    && index < (s.length() - 3)
            ) {

                stack.push(index);
                if (s.charAt(index + 2) == 'i') {
                    stack.pop();
                }
                index = index + 2;
            }
            if (!stack.isEmpty()) {
                System.out.println("Yes");

            } else if (stack.isEmpty() && s.charAt(s.length() - 2) == 'h' && s.charAt((s.length() - 1)) == 'i') {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
