package com.boqi.atcoders.abc.abc189;

import java.util.Scanner;

/**
 * 实际上就是计算
 * x1 (or/and) x2 (or/and) x3 (or/and) x4 = True 的感觉
 *
 * 这道题用dp去做，但是dp[i][j] 非常不好理解，我们用numOfTruePattern
 * 和numOfFalsePattern
 * 去做。
 *
 * numOfTruePattern[]: 到达第n个x的时候，前面的结果是true的可能性的组合种类
 * numOfFalsePattern[]: 到达第n个x的时候，前面的结果是false的可能性的组合种类
 * 从左向右看，如果读取的是 AND 的话
 * 那么，前面的xn只有可能是true，这样才能保证结果是true
 * 如果，前面的xn是false的话，那么再怎么样and也不会达到true

 * 因此 新的 numOfTruePattern[n] = 1 * numOfTruePattern[n-1]
 *                          0 * numOfFalsePattern[n-1]+；
 * 需要注意的是与falsePattern无关，
 *
 *  对于numOfFalsePattern来说，增加的可能性是：
 *  对于xn有两种取法，True或者false
 *
 * 本身numOfFalsePattern[n-1]肯定都是对的，因为不管xn怎么取，结果都是false
 * 所以 numOfFalsePattern[n] = 2* numOfFalsePattern[n-1] + ?
 * 同时，对与numOfTruePattern[n-1]而言，因为只有xn取到False的时候
 * numOfFalsePattern才能增加可能性
 * 所以 numOfFalsePattern[n] = 2* numOfFalsePattern[n-1] +
 *                            1 * numOfTruePattern[n-1]
 *
 * 对于Or的情况下同理。。
 *
 * 初始化而言
 * 因为题目告诉我们，Y0=X0
 * 所以NumOfTruePattern[0] 只有在 x0取True的时候 得到True
 * 因此numOfTruePattern[0] = 1
 * numOfFalsePattern[0] 同理
 *
 * 这道题想清楚的话，不是非常难理解，但是一定要思索清楚才行
 *
 */
public class D {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();

        long[] numOfTruePattern = new long[n+1];
        long[] numOfFalsePattern = new long[n+1];

        numOfTruePattern[0] = 1;
        numOfFalsePattern[0] = 1;

        for (int i = 1; i <= n; i++) {
            String logic = sc.next();
            if(logic.equals("AND")) {
                numOfTruePattern[i] = numOfTruePattern[i-1];
                numOfFalsePattern[i] =  numOfTruePattern[i-1]
                                      + 2 * numOfFalsePattern[i-1];
            } else { // OR的时候
                numOfTruePattern[i] = 2 * numOfTruePattern[i-1]
                                      + numOfFalsePattern[i-1];
                numOfFalsePattern[i] = numOfFalsePattern[i-1];
            }
        }

        System.out.println(numOfTruePattern[n]);
    }
}
