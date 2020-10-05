package com.senble.algorithm.week2;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

/**
 * 2叉大顶推
 *
 * @author : Senble
 * @version 1
 * @date : 2020/10/5
 */
public class BinaryHeapJava {

    public static class BinaryHeap {
        @NonNull
        private int[] elements;
        private int currentElementSize = 0;

        public BinaryHeap(int capacity) {
            this.elements = new int[capacity];
            currentElementSize = 0;
        }

        public void insert(int element) {
            if (currentElementSize >= elements.length) throw new IllegalStateException("堆大小超限");

            elements[currentElementSize++] = element;
            heapifyup(currentElementSize - 1);
        }

        private void heapifyup(int index) {
            int temp = elements[index];
            while (index != 0 && temp > elements[parent(index)]) {
                //父节点下沉
                elements[index] = elements[parent(index)];
                index = parent(index);
            }
            elements[index] = temp;
        }

        private void heapifydown(int index) {
            int temp = elements[index];
            int maxChildIndex = -1;
            while ((maxChildIndex = maxChild(index)) != -1 && elements[index] < elements[maxChildIndex]) {
                elements[index] = elements[maxChildIndex];
                index = maxChildIndex;
            }
            elements[index] = temp;
        }

        public int delete() {
            int maxElement = elements[0];
            //将最后一个放入堆顶
            elements[0] = elements[currentElementSize - 1];
            //容量减少
            currentElementSize--;
            heapifydown(0);
            return maxElement;
        }

        public boolean isFull() {
            return currentElementSize == elements.length - 1;
        }

        public boolean isEmpty() {
            return currentElementSize == 0;
        }

        private int parent(int index) {
            return (int) ((index - 1) / 2);
        }

        /**
         * 寻找index最大子节点
         *
         * @return 返回最大子节点index，无子节点返回-1
         */
        private int maxChild(int index) {
            int lcIndex = index * 2 + 1;
            int rcIndex = index * 2 + 2;
            if (currentElementSize < lcIndex) {
                return -1;
            } else if (currentElementSize <= lcIndex && currentElementSize < rcIndex) {
                return lcIndex;
            } else {
                return elements[lcIndex] >= elements[rcIndex] ? lcIndex : rcIndex;
            }
        }

        @NotNull
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("BinaryHeap: {");
            for (int i = 0; i < currentElementSize; i++) {
                sb.append(elements[i]);
                if (i != currentElementSize - 1) {
                    sb.append(",");
                }
            }
            return sb.append("}").toString();
        }
    }


    @Test
    public void test() {
        BinaryHeap binaryHeap = new BinaryHeap(7);
        binaryHeap.insert(20);
        binaryHeap.insert(60);
        binaryHeap.insert(30);
        binaryHeap.insert(80);
        binaryHeap.insert(90);
        binaryHeap.insert(70);
        binaryHeap.insert(50);

        System.out.println(binaryHeap.toString());

//        binaryHeap.delete();
//        binaryHeap.isFull();
//        System.out.println(binaryHeap.toString());


    }

}
