package com.senble.algorithm.week1;

import org.junit.Assert;
import org.junit.Test;

/**
 * 删除排序数组中的重复项
 * @author : Senble
 * @version 1
 * @date : 2020/9/26
 */
public class DeleteDuplicateArrayItem {
    @Test
    public void test() {
        //[0,0,1,1,1,2,2,3,3,4]
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int noDuplicateLength = removeDuplicates(nums);
        Assert.assertEquals(nums[0], 0);
        Assert.assertEquals(nums[1], 1);
        Assert.assertEquals(nums[2], 2);
        Assert.assertEquals(nums[3], 3);
        Assert.assertEquals(nums[4], 4);
        Assert.assertEquals(noDuplicateLength, 5);

        nums = new int[]{};
        noDuplicateLength = removeDuplicates(nums);
        Assert.assertEquals(noDuplicateLength, 0);

        noDuplicateLength = removeDuplicates(null);
        Assert.assertEquals(noDuplicateLength, 0);
    }

    public int removeDuplicates(int[] nums) {
        if(null == nums || nums.length == 0) {
            return 0;
        }

        int indexOfLastNoDuplicate = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[indexOfLastNoDuplicate]) {
                nums[++indexOfLastNoDuplicate] = nums[i];
            }
        }
        //从0开始算，长度需再+1
        return ++indexOfLastNoDuplicate;
    }
}
