package com.boqi.atcoders.abc.abc168;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        List<BigInteger> a = new ArrayList<>();
        List<BigInteger> b = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String as = sc.next();
            String bs = sc.next();
            BigInteger ai = new BigInteger(as);
            BigInteger bi = new BigInteger(bs);

            a.add(ai);
            b.add(bi);
        }

        BigInteger bzero = new BigInteger("0");
        BigInteger bone = new BigInteger("1");
        BigInteger res = new BigInteger("0");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n; j++) {
                BigInteger ai = a.get(i);
                BigInteger bi = b.get(i);
                BigInteger aj = a.get(j);
                BigInteger bj = b.get(j);

                if (!((ai.multiply(aj)).add(bi.multiply(bj))).equals(bzero)) {
                    res = res.add(bone);
                }
            }
        }
        BigInteger mod = new BigInteger("1000000007");
        System.out.println(res.mod(mod));

    }
}
