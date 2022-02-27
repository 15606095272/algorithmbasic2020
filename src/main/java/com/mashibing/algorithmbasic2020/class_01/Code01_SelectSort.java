package com.mashibing.algorithmbasic2020.class_01;

public class Code01_SelectSort {

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            Code00_RandomArrayUtil.swap(arr, i, minIndex);
        }
    }
}
