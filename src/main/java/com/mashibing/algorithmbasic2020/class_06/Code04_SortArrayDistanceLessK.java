package com.mashibing.algorithmbasic2020.class_06;

import com.mashibing.algorithmbasic2020.class_01.Code00_RandomArrayUtil;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Code04_SortArrayDistanceLessK {

    public static void sortArrayDistanceLessK(int[] arr, int k) {
        if (k == 0) {
            return;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index <= Math.min(arr.length - 1, k - 1); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        // !heap.isEmpty()
        while (i < arr.length) {
            arr[i++] = heap.poll();
        }
    }

    public static void comparator(int[] arr, int k) {
        Arrays.sort(arr);
    }

    public static int[] randomArrayNoMoveMoreK(int maxSize, int maxValue, int K) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        // 先排个序
        Arrays.sort(arr);
        // 然后开始随意交换，但是保证每个数距离不超过K
        // swap[i] == true, 表示i位置已经参与过交换
        // swap[i] == false, 表示i位置没有参与过交换
        boolean[] isSwap = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int j = Math.min(i + (int) (Math.random() * (K + 1)), arr.length - 1);
            if (!isSwap[i] && !isSwap[j]) {
                isSwap[i] = true;
                isSwap[j] = true;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int k = (int) (Math.random() * maxSize) + 1;
            int[] arr = randomArrayNoMoveMoreK(maxSize, maxValue, k);
            int[] arr1 = Code00_RandomArrayUtil.copyArray(arr);
            int[] arr2 = Code00_RandomArrayUtil.copyArray(arr);
            sortArrayDistanceLessK(arr1, k);
            comparator(arr2, k);
            if (!Code00_RandomArrayUtil.isEqual(arr1, arr2)) {
                succeed = false;
                System.out.println("K : " + k);
                Code00_RandomArrayUtil.printArray(arr);
                Code00_RandomArrayUtil.printArray(arr1);
                Code00_RandomArrayUtil.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
