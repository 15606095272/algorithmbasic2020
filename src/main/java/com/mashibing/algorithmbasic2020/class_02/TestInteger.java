package com.mashibing.algorithmbasic2020.class_02;

public class TestInteger {

    public static void main(String[] args) {
        Integer integer = 127;
        Integer intA = 127;
        Integer.valueOf(127);
        Long.valueOf(127);
        System.out.println(integer == intA);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Integer a = i;
            Integer b = i;
            if (a != b) {
                System.out.println(i);
                break;
            }
        }
    }
}
