package com.senble.algorithm.week1

import org.junit.Assert
import org.junit.Test

/**
 * 88：Merge Sorted Array
 * @author : Senble
 * @version 1
 * @date : 2020/9/26
 */
class MergeSortedArray {

    fun merge(nums1: IntArray, n1: Int, nums2: IntArray, n2: Int) {
        val copyOfNum1 = nums1.copyOf()

        var i = 0
        var j = 0
        var k = 0
//
//        for (k in 0 until (n1 + n2)) {
//            if (i >= n1) {
//                nums1[k] = nums2[j++]
//            } else if (j >= n2){
//                nums1[k] = copyOfNum1[i++]
//            } else {
//                if (copyOfNum1[i] < nums2[j]) {
//                    nums1[k] = copyOfNum1[i++]
//                } else {
//                    nums1[k] = nums2[j++]
//                }
//            }
//        }


        while (i < n1 && j < n2) {
            nums1[k++] = if (copyOfNum1[i] < nums2[j]) copyOfNum1[i++] else nums2[j++]
        }

        if (i < n1) System.arraycopy(copyOfNum1, i, nums1, i+j, n1 - i)
        if (j < n2) System.arraycopy(nums2, j, nums1, i+j, n2 - j)
    }

    @Test
    fun test() {
        val nums1 = intArrayOf(1,2,6,0,0,0)
        val nums2 = intArrayOf(5, 6, 7)
        merge(nums1, 3, nums2, 3)
        System.out.println(nums1.joinToString())
        Assert.assertArrayEquals(intArrayOf(1, 2, 5, 6, 6, 7), nums1)
    }
}