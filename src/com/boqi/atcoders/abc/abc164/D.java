package com.boqi.atcoders.abc.abc164;

import java.math.BigInteger;
import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sc.next();
        String sub = "";
        int ans = 0;
        for(int i = 0; i < s.length()-1; i++){
            for (int j = i+1; j<s.length(); j++){
                sub = s.substring(i, j+1);
                BigInteger k = new BigInteger(sub);
                if (is2019(k)){
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
    static boolean is2019(BigInteger number){
        return number.remainder(new BigInteger("2019")).equals(new BigInteger("0"));
    }
}
