package com.mashibing.algorithmbasic2020.class_03;

import com.mashibing.algorithmbasic2020.class_01.Code00_RandomArrayUtil;

public class Code03_ReversePair {

    public static int reversePair(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = help.length - 1;
        int p1 = mid;
        int p2 = r;
        int res = 0;
        while (p1 >= l && p2 > mid) {
            res += arr[p1] > arr[p2] ? p2 - mid : 0;
            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1 >= l) {
            help[i--] = arr[p1--];
        }
        while (p2 > mid) {
            help[i--] = arr[p2--];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }

    public static int comparator(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                res += arr[i] > arr[j] ? 1 : 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Code00_RandomArrayUtil.randomArray(maxSize, maxValue);
            int[] arr2 = Code00_RandomArrayUtil.copyArray(arr1);
            if (reversePair(arr1) != comparator(arr2)) {
                System.out.println("Oops!");
                Code00_RandomArrayUtil.printArray(arr1);
                Code00_RandomArrayUtil.printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
