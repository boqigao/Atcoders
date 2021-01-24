package com.boqi.atcoders.abc.abc158;

public class DivisibleSubString {

    public static void main(String[] args) {
        test("2020", 2);
    }

    static void test(String s, int prime) {
        int count = 0;
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                temp = s.substring(i, j);
                int tempInt = Integer.parseInt(temp);
                if (tempInt % prime == 0) {
                    count++;
                    //System.out.println(tempInt);
                }
            }
        }
        System.out.println(count);

    }
}
