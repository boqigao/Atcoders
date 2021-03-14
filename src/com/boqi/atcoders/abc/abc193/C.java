package com.boqi.atcoders.abc.abc193;

import java.util.*;

public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        long n =sc.nextLong();
        List<Integer> primes = new ArrayList<Integer>();
        int number = 100000;
        int[] isPrime = new int[number];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < number; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < number; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        long ans = n;
        Set<Long> memo = new HashSet<>();
        for (int i = 0; i < primes.size(); i++) {
            for (int j = 2; j < 100; j++) {
                long tmp = (long)Math.pow(primes.get(i), j);
                if (tmp <= n && !memo.contains(tmp)) {
                    ans--;
                    memo.add(tmp);
                } else {
                    break;
                }
            }

        }
        System.out.println(ans);
    }
}
