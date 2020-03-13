package com.boqi.atcoders.abc.abc156;

import java.math.BigInteger;
import java.util.Scanner;

public class Bouquet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            final int n = sc.nextInt();
            final int a = sc.nextInt();
            final int b = sc.nextInt();

            long pow = pow(2, n, 1000000007);
            long nca = nCr(n, a, 1000000007);
            long ncb = nCr(n, b, 1000000007);

            long result = pow - 1;
            result = result - nca;
            if (result < 0) {
                result += 1000000007;
            }
            result = result - ncb;
            if (result < 0) {
                result += 1000000007;
            }
            System.out.println(result);

        } finally {
            sc.close();
        }
    }

    public static long nCr(int n, int r, int mod){
        long num = 1;
        for (int i=1; i<=r; i++) {
            num *= n;
            num %= mod;
            n--;
        }

        long invr = pow(factorial(r, mod), mod - 2, mod);

        return num * invr % mod;
    }

    public static long pow(long a, long x, long mod) {
        return BigInteger.valueOf(a).modPow(BigInteger.valueOf(x),  BigInteger.valueOf(mod)).longValue();
    }

    public static long factorial(long n, long mod) {
        long result = 1;
        for (long i=n; i>0; i--) {
            result *= i;
            result %= mod;
        }
        return result;
    }
}
