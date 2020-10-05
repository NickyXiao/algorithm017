package com.senble.algorithm.week2

import org.junit.Assert
import org.junit.Test

/**
 * Valid Anagram有效异位词
 * @author : Senble
 * @version 1
 * @date : 2020/9/29
 */
class ValidAnagram {

    fun isAnagram(s: String, t: String): Boolean {
        return s.toSortedSet().toString() == t.toSortedSet().toString()
    }

    fun isAnagram2(s: String, t: String): Boolean {
        val alphabetAppearsTimesArr = IntArray('z' - 'a' + 1)
        s.toCharArray().forEach {
            alphabetAppearsTimesArr[it - 'a']++
        }
        t.toCharArray().forEach {
            alphabetAppearsTimesArr[it - 'a']--
            if (alphabetAppearsTimesArr[it - 'a'] == -1) return false
        }
        return alphabetAppearsTimesArr.all { it == 0 }
    }

    @Test
    fun test() {
        //Input: s = "anagram", t = "nagaram"
        //Output: true
        Assert.assertTrue(isAnagram("anagram", "nagaram"))

        Assert.assertFalse(isAnagram2("rat", "cat"))
    }
}