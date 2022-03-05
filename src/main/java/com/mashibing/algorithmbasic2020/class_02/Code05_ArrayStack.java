package com.mashibing.algorithmbasic2020.class_02;

public class Code05_ArrayStack {

    public static class MyStack {
        private int index;

        private int[] arr;

        private final int limit;

        public MyStack(int limit) {
            arr = new int[limit];
            index = 0;
            this.limit = limit;
        }

        public void push(int value) throws Exception {
            if (index == limit) {
                throw new Exception("栈满了");
            }
            arr[index] = value;
            index++;
        }

        public int pop() throws Exception {
            if (index == 0) {
                throw new Exception("栈是空的");
            }
            int value = arr[index - 1];
            index--;
            return value;
        }

        public boolean isEmpty() {
            return index == 0;
        }
    }
}
