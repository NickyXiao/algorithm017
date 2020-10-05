package com.senble.algorithm.week2

import android.content.res.Resources
import org.junit.Assert
import org.junit.Test

/**
 * Two Sum
 * @author : Senble
 * @version 1
 * @date : 2020/9/29
 */
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        //遍历array，构造HashMap
        val numsIndexMap = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, value -> numsIndexMap[value] = index }
        //寻找
        nums.forEachIndexed { index, value ->
            val other = target - value
            if (numsIndexMap.containsKey(other) && numsIndexMap[other] != index) {
                return intArrayOf(index, numsIndexMap[other]!!)
            }
        }
        throw Resources.NotFoundException("没有找到")
    }

    fun twoSum2(nums: IntArray, target: Int): IntArray {
        //遍历array，构造HashMap
        val numsIndexMap = mutableMapOf<Int, Int>()
        //寻找
        nums.forEachIndexed { index, value ->
            val other = target - value
            if (numsIndexMap.containsKey(other) && numsIndexMap[other] != index) {
                //已遍历过的需要在前面
                return intArrayOf(numsIndexMap[other]!!, index)
            }
            numsIndexMap[value] = index
        }
        throw Resources.NotFoundException("没有找到")
    }

    @Test
    fun test() {
        //Input: nums = [2,7,11,15], target = 9
        //Output: [0,1]
        //Output: Because nums[0] + nums[1] == 9, we return [0, 1].

        Assert.assertArrayEquals(intArrayOf(0, 1), twoSum(intArrayOf(2,7,11,15), 9))

        Assert.assertArrayEquals(intArrayOf(0, 1), twoSum2(intArrayOf(2,7,11,15), 9))
    }
}