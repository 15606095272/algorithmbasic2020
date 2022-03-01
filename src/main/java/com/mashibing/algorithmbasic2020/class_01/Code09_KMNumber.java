package com.mashibing.algorithmbasic2020.class_01;

public class Code09_KMNumber {

    public static int onlyKTimes(int[] arr, int k, int m) {
        int[] binaryArr = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                binaryArr[i] += (num >> i) & 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (binaryArr[i] % m != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
