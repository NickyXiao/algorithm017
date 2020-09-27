package com.senble.algorithm.week1;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author : Senble
 * @version 1
 * @date : 2020/9/23
 */
public class ChangeApi {
    @Test
    public void learnDequeApi() {
        Deque<String> stringDeque = new LinkedList<>();
        stringDeque.addLast("a");
        stringDeque.addLast("b");
        stringDeque.addLast("c");
        System.out.println(stringDeque);

        String str = stringDeque.peekFirst();
        System.out.println(str);
        System.out.println(stringDeque);

        while (stringDeque.size() > 0) {
            System.out.println(stringDeque.removeFirst());
        }
        System.out.println(stringDeque);
    }
}
