package com.mashibing.algorithmbasic2020.class_06;

import com.mashibing.algorithmbasic2020.class_01.Code00_RandomArrayUtil;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Code03_HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        Code00_RandomArrayUtil.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            Code00_RandomArrayUtil.swap(arr, 0, --heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            Code00_RandomArrayUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left]
                    ? left + 1 : left;
            if (arr[largest] < arr[index]) {
                break;
            }
            Code00_RandomArrayUtil.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {

        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(6);
        heap.add(8);
        heap.add(0);
        heap.add(2);
        heap.add(9);
        heap.add(1);

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Code00_RandomArrayUtil.randomArray(maxSize, maxValue);
            int[] arr2 = Code00_RandomArrayUtil.copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!Code00_RandomArrayUtil.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = Code00_RandomArrayUtil.randomArray(maxSize, maxValue);
        Code00_RandomArrayUtil.printArray(arr);
        heapSort(arr);
        Code00_RandomArrayUtil.printArray(arr);
    }

}
