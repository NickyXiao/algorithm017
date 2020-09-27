package com.senble.algorithm.week1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Rotate Array
 * <p>
 * 要求：
 * 1、空间复杂度O（1）
 * 2、原地
 *
 * @author : Senble
 * @version 1
 * @date : 2020/9/26
 */
public class RotateArray {
    public void bruteForce(int[] nums, int k) {
        if (null == nums) {
            return;
        }

        k = k % nums.length;
        if (k == 0) {
            //移动次数是数组长度整数倍，数组不变
            return;
        }

        int temp = 0;
        int next = 0;
        int pre = 0;
        //移k次
        for (int i = 0; i < k; i++) {
            pre = nums[0];
            //每次移动一位
            for (int j = 0; j < nums.length; j++) {
                next = (j + 1) % nums.length;
                temp = nums[next];
                nums[next] = pre;
                pre = temp;
            }
        }
    }

    public void rotate(int[] nums, int k) {
        if (null == nums) {
            return;
        }

        k = k % nums.length;
        if (k == 0) {
            //移动次数是数组长度整数倍，数组不变
            return;
        }

        int temp;
        int count = 0;
        int next;
        int pre;
        for (int start = 0; count < nums.length; start++) {
            pre = nums[start];
            next = start;
            do {
                next = (next + k) % nums.length;

                temp = nums[next];
                nums[next] = pre;
                pre = temp;
                count++;
            } while (next != start);
        }
    }

    private void rotateByReverse(int[] nums, int k) {
        if (null == nums) {
            return;
        }

        k = k % nums.length;
        if (k == 0) {
            //移动次数是数组长度整数倍，数组不变
            return;
        }

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            //交换收尾
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        bruteForce(nums, 1);
        Assert.assertArrayEquals(new int[]{7, 1, 2, 3, 4, 5, 6}, nums);

        bruteForce(nums, 1);
        Assert.assertArrayEquals(new int[]{6, 7, 1, 2, 3, 4, 5}, nums);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        bruteForce(nums, 4);
        Assert.assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, nums);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 4);
        Assert.assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, nums);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateByReverse(nums, 4);
        Assert.assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, nums);
    }
}
