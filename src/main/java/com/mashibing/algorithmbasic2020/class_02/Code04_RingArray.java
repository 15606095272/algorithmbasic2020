package com.mashibing.algorithmbasic2020.class_02;

public class Code04_RingArray {

    public static class MyQueue {

        private int[] arr;

        private int pushI;

        private int pollI;

        private int size;

        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushI = 0;
            pollI = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) throws Exception {
            if (size == limit) {
                throw new Exception("队列满了");
            }
            size++;
            arr[pushI] = value;
            pushI = nextIndex(pushI);
        }

        public int poll() throws Exception {
            if (size == 0) {
                throw new Exception("队列是空的");
            }
            size--;
            int value = arr[pollI];
            pollI = nextIndex(pollI);
            return value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }
    }


}
