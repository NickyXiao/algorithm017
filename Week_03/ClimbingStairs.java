package com.senble.algorithm.week3;

import org.junit.Test;

/**
 * Climbing Stairs
 * @author : Senble
 * @version 1
 * @date : 2020/10/6
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int fn_1 = 1;
        int fn_2 = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = result;
        }
        return result;
    }

    @Test
    public void test() {

    }
}
