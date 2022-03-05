package com.mashibing.algorithmbasic2020.class_02;

import com.sun.org.apache.bcel.internal.generic.POP;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code03_DoubleEndsQueueToStackAndQueue {

    public static class Node<T> {
        private T value;

        private Node<T> last;

        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public static class DoubleEndsQueue<T> {
        private Node<T> head;

        private Node<T> tail;

        public void addFromHead(T value) {
            Node<T> cur = new Node<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                head.last = cur;
                cur.next = head;
                head = cur;
            }
        }

        public void addFromBottom(T value) {
            Node<T> cur = new Node<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            }
        }

        public T popFromHead() {
            if (isEmpty()) {
                return null;
            }
            Node<T> value = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
                value.next = null;
            }
            return value.value;
        }

        public T popFromBottom() {
            if (isEmpty()) {
                return null;
            }
            Node<T> value = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
                value.last = null;
            }
            return value.value;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    public static class MyQueue<T> {
        private DoubleEndsQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndsQueue<>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T poll() {
            return queue.popFromBottom();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static class MyStack<T> {
        private DoubleEndsQueue<T> stack;

        public MyStack() {
            stack = new DoubleEndsQueue<>();
        }

        public void push(T value) {
            stack.addFromHead(value);
        }

        public T pop() {
            return stack.popFromHead();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    public static boolean isEqual(Integer i1, Integer i2) {
        if (i1 == null && i2 != null) {
            return false;
        }

        if (i1 != null && i2 == null) {
            return false;
        }

        if (i1 == null && i2 == null) {
            return true;
        }

        return i1.equals(i2);
    }

    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyQueue<Integer> myQueue = new MyQueue<>();
            MyStack<Integer> myStack = new MyStack<>();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                Integer nums = (int) (Math.random() * value);
                if (myStack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (!isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }
            }
            Integer numq = (int) (Math.random() * value);
            if (myQueue.isEmpty()) {
                myQueue.push(numq);
                queue.offer(numq);
            } else {
                if (Math.random() < 0.5) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (!isEqual(myQueue.poll(), queue.poll())) {
                        System.out.println("oops!");
                    }
                }
            }
        }
        System.out.println("finish!");
    }
}
