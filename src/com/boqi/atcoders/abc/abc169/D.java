package com.boqi.atcoders.abc.abc169;


import java.util.*;

public class D {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long n = sc.nextLong();

        if (n == 1) {
            System.out.println("0");
            return;
        }

        //如果一开始就是质数，那就return
        if (isPrime(n)) {
            System.out.println("1");
            return;
        }

        int ans = 0;
        Set<Long> zSet = new HashSet<>();

        List<Long> primes = findPrime2(1000000L);
        //如果一开始不是质数，先做出质数列表
        for (int i = 0; i < primes.size(); i++) {
            long p = primes.get(i);
            for (int j = 1; j < n; j++) {
                long z = (long) Math.pow(p, j);
                if (z > n) {
                    break;
                }
                if (n % z == 0) {
                    //System.out.println("z = " + z);
                    n = n / z;
                    zSet.add(z);
                    //System.out.println("n = " + n);
                    ans++;
                    if (isPrime(n)) {
                        if (zSet.contains(n) || n == 1) {
                            System.out.println(ans);
                            return;
                        } else {
                            System.out.println(ans + 1);
                            return;
                        }
                    }
                }
            }
        }
    }

    public static boolean isPrime(long n) {

        for (long i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


    public static List<Long> findPrime2(long n) {
        List<Long> primes = new ArrayList<>();
        primes.add(2L);
        for (long i = 3; i <= n; i++) {
            long tmp = (long) Math.sqrt(i) + 1;
            for (long j = 2; j <= tmp; j++) {
                if (i % j == 0) {
                    break;
                }
                if (j == tmp) {
                    primes.add(i);
                }
            }
        }
        return primes;
    }

}
