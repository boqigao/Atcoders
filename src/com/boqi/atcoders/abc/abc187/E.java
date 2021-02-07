package com.boqi.atcoders.abc.abc187;

import java.util.Scanner;

/**
 * 先把这道题考虑成一个有根的树
 *
 * 然后，这道题分两种情况考虑：
 * 第一种，是从子节点到父节点的通路无法走通，那么就在这棵子树+x
 * 第二种，是从父节点到子节点的通路无法走通，那么就给整棵树+x，然后子树-x
 *
 * 然后对于这种树状结构，或者数组的话，我们可以只记录差分，类似于abc188的D问题
 *
 */
public class E {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
    }
}
