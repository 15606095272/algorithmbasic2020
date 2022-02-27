package com.mashibing.algorithmbasic2020.class_01;

import java.util.Arrays;

public class Code05_NearLeft {

    public static int nearLeft(int[] arr, int num) {
        if (arr == null) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] >= num) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    public static int test(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = Code00_RandomArrayUtil.randomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != nearLeft(arr, value)) {
                Code00_RandomArrayUtil.printArray(arr);
                System.out.println(value);
                System.out.println(test(arr, value));
                System.out.println(nearLeft(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
