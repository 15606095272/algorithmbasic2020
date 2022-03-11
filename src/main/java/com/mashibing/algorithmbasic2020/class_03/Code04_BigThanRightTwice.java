package com.mashibing.algorithmbasic2020.class_03;

import com.mashibing.algorithmbasic2020.class_01.Code00_RandomArrayUtil;

public class Code04_BigThanRightTwice {

    public static int bigThanRightTwice(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        // l < r
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int mid, int r) {
        int res = 0;
        int windowR = mid + 1;
        for (int i = l; i <= mid; i++) {
            while (windowR <= r && arr[i] > (arr[windowR] << 1)) {
                windowR++;
            }
            res += windowR - mid - 1;
        }
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }

    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > (arr[j] << 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Code00_RandomArrayUtil.randomArray(maxSize, maxValue);
            int[] arr2 = Code00_RandomArrayUtil.copyArray(arr1);
            if (bigThanRightTwice(arr1) != comparator(arr2)) {
                System.out.println("Oops!");
                Code00_RandomArrayUtil.printArray(arr1);
                Code00_RandomArrayUtil.printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
