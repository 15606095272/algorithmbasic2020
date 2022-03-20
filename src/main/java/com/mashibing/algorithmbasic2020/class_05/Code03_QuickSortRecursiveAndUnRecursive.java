package com.mashibing.algorithmbasic2020.class_05;

import com.mashibing.algorithmbasic2020.class_01.Code00_RandomArrayUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.Level;

public class Code03_QuickSortRecursiveAndUnRecursive {

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
        Code00_RandomArrayUtil.swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        Code00_RandomArrayUtil.swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int[] equalArea = netherlandsFlag(arr, l, r);
        process(arr, l, equalArea[0] - 1);
        process(arr, equalArea[1] + 1, r);
    }

    static class Op {
        private int l;
        private int r;

        Op(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;
        Code00_RandomArrayUtil.swap(arr, (int) (Math.random() * (length)), length - 1);
        int[] equalArea = netherlandsFlag(arr, 0, length - 1);
        int el = equalArea[0];
        int er = equalArea[1];
        Stack<Op> stack = new Stack<>();
        stack.push(new Op(0, el - 1));
        stack.push(new Op(er + 1, length - 1));
        while (!stack.isEmpty()) {
            Op op = stack.pop();
            if (op.l < op.r) {
                Code00_RandomArrayUtil.swap(arr, op.l + (int) (Math.random() * (op.r - op.l + 1)), op.r);
                equalArea = netherlandsFlag(arr, op.l, op.r);
                el = equalArea[0];
                er = equalArea[1];
                stack.push(new Op(op.l, el - 1));
                stack.push(new Op(er + 1, op.r));
            }
        }
    }

    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;
        Code00_RandomArrayUtil.swap(arr, (int) (Math.random() * (length)), length - 1);
        int[] equalArea = netherlandsFlag(arr, 0, length - 1);
        int el = equalArea[0];
        int er = equalArea[1];
        Queue<Op> queue = new LinkedList<>();
        queue.offer(new Op(0, el - 1));
        queue.offer(new Op(er + 1, length - 1));
        while (!queue.isEmpty()) {
            Op op = queue.poll();
            if (op.l < op.r) {
                Code00_RandomArrayUtil.swap(arr, op.l + (int) (Math.random() * (op.r - op.l + 1)), op.r);
                equalArea = netherlandsFlag(arr, op.l, op.r);
                el = equalArea[0];
                er = equalArea[1];
                queue.offer(new Op(op.l, el - 1));
                queue.offer(new Op(er + 1, op.r));
            }
        }
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
