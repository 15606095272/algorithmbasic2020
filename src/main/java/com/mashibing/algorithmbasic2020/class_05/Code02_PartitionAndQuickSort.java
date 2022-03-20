package com.mashibing.algorithmbasic2020.class_05;

import com.mashibing.algorithmbasic2020.class_01.Code00_RandomArrayUtil;

public class Code02_PartitionAndQuickSort {

    public static int partition(int[] arr, int l, int r) {
        if (l > r) {
            return -1;
        }
        if (l == r) {
            return l;
        }
        int lessEqual = l - 1;
        int index = l;
        while (index < r) {
            if (arr[index] <= arr[r]) {
                Code00_RandomArrayUtil.swap(arr, index, ++lessEqual);
            }
            index++;
        }
        Code00_RandomArrayUtil.swap(arr, r, ++lessEqual);
        return lessEqual;
    }

    public static int[] netherlandsFlag(int[] arr, int l, int r) {
        if (l > r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, r};
        }
        int less = l - 1;
        int more = r;
        int index = l;
        while (index < more) {
            if (arr[index] == arr[r]) {
                index++;
            } else if (arr[index] < arr[r]) {
                Code00_RandomArrayUtil.swap(arr, index++, ++less);
            } else {
                Code00_RandomArrayUtil.swap(arr, index, --more);
            }
        }
        Code00_RandomArrayUtil.swap(arr, r, more);
        return new int[]{less + 1, more};
    }

    public static void process1(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = partition(arr, l, r);
        process1(arr, l, m - 1);
        process1(arr, m + 1, r);
    }

    public static void process2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int[] equalArea = netherlandsFlag(arr, l, r);
        process2(arr, l, equalArea[0] - 1);
        process2(arr, equalArea[1] + 1, r);
    }

    public static void process3(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        Code00_RandomArrayUtil.swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int[] equalArea = netherlandsFlag(arr, l, r);
        process3(arr, l, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, r);
    }

    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Code00_RandomArrayUtil.randomArray(maxSize, maxValue);
            int[] arr2 = Code00_RandomArrayUtil.copyArray(arr1);
            int[] arr3 = Code00_RandomArrayUtil.copyArray(arr1);
            quickSort1(arr1);
            quickSort2(arr2);
            quickSort3(arr3);
            if (!Code00_RandomArrayUtil.isEqual(arr1, arr2) || !Code00_RandomArrayUtil.isEqual(arr2, arr3)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oops!");
    }
}
