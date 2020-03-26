package com.boqi.atcoders.abc.abc159;

import java.util.Scanner;

public class BStringPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int n = s.length();
        String sub1 = s.substring(0, ((n-1)/2));
        String sub2 = s.substring(((n+3)/2)-1, n );

        if(isPalindrome(s) && isPalindrome(sub1) && isPalindrome(sub2)){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }

    static boolean isPalindrome(String str)
    {

        // Pointers pointing to the beginning
        // and the end of the string
        int i = 0, j = str.length() - 1;

        // While there are characters toc compare
        while (i < j) {

            // If there is a mismatch
            if (str.charAt(i) != str.charAt(j))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }

        // Given string is a palindrome
        return true;
    }
}
