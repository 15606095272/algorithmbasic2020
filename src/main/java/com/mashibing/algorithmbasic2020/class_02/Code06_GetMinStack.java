package com.mashibing.algorithmbasic2020.class_02;

import java.util.Stack;

public class Code06_GetMinStack {

    public static class MyStack1 {

        private Stack<Integer> stackData;

        private Stack<Integer> stackMin;

        public MyStack1() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int value) throws Exception {
            if (stackMin.isEmpty()) {
                stackMin.push(value);
            } else if (value <= getMin()) {
                stackMin.push(value);
            }
            stackData.push(value);
        }

        public int pop() throws Exception {
            if (stackData.isEmpty()) {
                throw new Exception("栈是空的");
            }
            int value = stackData.pop();
            if (value == getMin()) {
                stackMin.pop();
            }
            return value;
        }

        public int getMin() throws Exception {
            if (stackMin.isEmpty()) {
                throw new Exception("最小栈是空的");
            }
            return stackMin.peek();
        }
    }

    public static class MyStack2 {

        private Stack<Integer> stackData;

        private Stack<Integer> stackMin;

        public MyStack2() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int value) throws Exception {
            if (stackMin.isEmpty()) {
                stackMin.push(value);
            } else if (value < getMin()) {
                stackMin.push(value);
            } else {
                stackMin.push(getMin());
            }
            stackData.push(value);
        }

        public int pop() throws Exception {
            if (stackData.isEmpty()) {
                throw new Exception("栈是空的");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin() throws Exception {
            if (stackMin.isEmpty()) {
                throw new Exception("最小栈是空的");
            }
            return stackMin.peek();
        }
    }

    public static void main(String[] args) throws Exception {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("=============");

        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }
}
