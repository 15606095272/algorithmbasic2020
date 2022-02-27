package com.mashibing.algorithmbasic2020.class_01;

public class Code08_EvenTimesOddTimesNumber {

    public static void oddTimesNumber(int[] arr) {
        int eor = 0;
        for (int value : arr) {
            eor ^= value;
        }
        System.out.println(eor);
    }

    public static void twoOddTimesNumber(int[] arr) {
        int eor = 0;
        for (int value : arr) {
            eor ^= value;
        }
        int rightOne = eor & (-eor);
        int firstOddTimesNumber = 0;
        for (int value : arr) {
            if ((value & rightOne) != 0) {
                firstOddTimesNumber ^= value;
            }
        }
        System.out.println(firstOddTimesNumber + " " + (eor ^ firstOddTimesNumber));
    }
}
