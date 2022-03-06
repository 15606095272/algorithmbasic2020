package com.mashibing.algorithmbasic2020.class_02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code08_TwoQueueImplementStack {

    public static class TwoQueueStack {

        private Queue<Integer> queue;

        private Queue<Integer> help;

        public TwoQueueStack() {
            this.queue = new LinkedList<>();
            this.help = new LinkedList<>();
        }

        public void push(int value) {
            queue.offer(value);
        }

        public int pop() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            int value = queue.poll();
            Queue<Integer> temp = queue;
            queue = help;
            help = temp;
            return value;
        }

        public int peek() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            int value = queue.poll();
            help.offer(value);
            Queue<Integer> temp = queue;
            queue = help;
            help = temp;
            return value;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        TwoQueueStack test = new TwoQueueStack();
        Stack<Integer> stack = new Stack<>();
        int testTimes = 1000000;
        int max = 1000000;

        for (int i = 0; i < testTimes; i++) {
            if (test.isEmpty()) {
                if (!stack.isEmpty()) {
                    System.out.println("Oops!");
                }
                int num = (int) (Math.random() * max);
                test.push(num);
                stack.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    test.push(num);
                    stack.push(num);
                } else if (Math.random() < 0.5) {
                    if (!stack.peek().equals(test.peek())) {
                        System.out.println("Oops!");
                    }
                } else if (Math.random() < 0.75) {
                    if (!stack.pop().equals(test.pop())) {
                        System.out.println("Oops!");
                    }
                } else {
                    if (test.isEmpty() != stack.isEmpty()) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        System.out.println("test finish");
    }
}
