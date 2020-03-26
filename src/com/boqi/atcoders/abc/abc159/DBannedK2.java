package com.boqi.atcoders.abc.abc159;

import java.util.Scanner;

/**
 * 太精彩了，用了桶排序的原理
 * 简单方法：如果单纯要从一个序列中求所有相同元素的choose的总和，那一定是O（N^2）
 *          因为要一列一类比对
 * 如果使用桶排序：相当于把所有相同数字放到一个桶里，然后只要求所有桶的nC2就可以了
 *
 */
public class DBannedK2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        //结果数字
        long res = 0;

        long[] b = new long[n]; //建立一个存储的桶

        //将相同的元素a放到桶中
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            b[a[i]-1]++;
        }

        for(int i = 0; i < n; i++){
            //其实这里就是实现了一个选择函数
            res += b[i]*(b[i]-1)/2;
        }

        for(int i = 0; i < n; i++){
            //这里非常重要
            //对于不计算某个a[k]来说，实际上只要去掉所有的和a[k]相同的数字就可以了
            /**
             * 举例
             * 比如说a[k] = {1,1,1,1,2,3}
             * 此时b是[4,1,1] ，同时总和是4*3/2 = 6;
             * 那当我们不计算a[0]，也就是第一个1的时候
             * 我们需要从6中抛去什么呢？
             * 我们要从剩下的k-1个数中，抛去和1相同数字的数量
             * 因为如果相同的话，就还是会被计算到总和里
             */
            System.out.println(res-(b[a[i]-1]-1));
            //上面的这个b[?]-1就是抛出了这个数字
        }
    }

    //选择函数
    static int choose (int n, int k){
        int ret = 1;
        if(n == k) {
            return 1;
        }else {
            for(int i = 0; i < k; i++){
                ret = ret * (n-i) / (i + 1);
            }
            return ret;}
    }
}

