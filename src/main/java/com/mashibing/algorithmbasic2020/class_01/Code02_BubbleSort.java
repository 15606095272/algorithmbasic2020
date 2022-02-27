package com.mashibing.algorithmbasic2020.class_01;


public class Code02_BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Code00_RandomArrayUtil.swap(arr, j + 1, j);
                }
            }
        }
    }
}
