package com.mashibing.algorithmbasic2020.class_01;

public class Code03_InsertSort {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i ++) {
            for (int j = i - 1; j >=0 && arr[j] > arr[j + 1]; j--) {
                Code00_RandomArrayUtil.swap(arr, j, j + 1);
            }
        }
    }
}
