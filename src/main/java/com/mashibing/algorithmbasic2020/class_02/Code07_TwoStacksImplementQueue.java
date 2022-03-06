package com.mashibing.algorithmbasic2020.class_02;

import java.util.Stack;

public class Code07_TwoStacksImplementQueue {

    public static class TwoStackQueue {

        private Stack<Integer> stackPush;

        private Stack<Integer> stackPop;

        public TwoStackQueue() {
            this.stackPush = new Stack<>();
            this.stackPop = new Stack<>();
        }

        private void pushToPop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(int value) {
            stackPush.push(value);
            pushToPop();
        }

        public int poll() throws Exception {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new Exception("队列是空的");
            }
            pushToPop();
            return stackPop.pop();
        }

        public int peek() throws Exception {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new Exception("队列是空的");
            }
            pushToPop();
            return stackPop.peek();
        }
    }

    public static void main(String[] args) throws Exception {
        TwoStackQueue test = new TwoStackQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());

    }
}
