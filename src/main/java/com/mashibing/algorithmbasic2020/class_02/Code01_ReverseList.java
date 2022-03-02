package com.mashibing.algorithmbasic2020.class_02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linshijin
 * @date 2022/3/2 18:57
 */
public class Code01_ReverseList {

    public static class Node {
        private int value;

        private Node next;

        public Node(int val) {
            value = val;
        }
    }

    public static class DoubleNode {
        private int value;

        private DoubleNode last;

        private DoubleNode next;

        public DoubleNode(int val) {
            value = val;
        }
    }

    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleNode(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node testReverseNode(Node head) {
        if (head == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        for (int i = 1; i < list.size(); i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(list.size() - 1);
    }

    public static DoubleNode testReverseDoubleNode(DoubleNode head) {
        if (head == null) {
            return null;
        }
        List<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        DoubleNode pre = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            DoubleNode cur = list.get(i);
            cur.last = null;
            cur.next = pre;
            pre.last = cur;
            pre = cur;
        }
        return list.get(list.size() - 1);
    }

    public static Node generateRandomList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        Node head = new Node((int) (Math.random() * (value + 1)));
        Node pre = head;
        while (size != 0) {
            Node cur = new Node((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    public static DoubleNode generateRandomDoubleList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        DoubleNode head = new DoubleNode((int) (Math.random() * (value + 1)));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            cur.last = pre;
            pre = cur;
            size--;
        }
        return head;
    }

    public static boolean checkLinkedListEqual(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.value != head2.value) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }

    public static boolean checkDoubleListEqual(DoubleNode head1, DoubleNode head2) {
        boolean null1 = head1 == null;
        boolean null2 = head2 == null;
        if (null1 && null2) {
            return true;
        }
        if (null1 ^ null2) {
            return false;
        }
        if (head1.last != null || head2.last != null) {
            return false;
        }
        DoubleNode end1 = null;
        DoubleNode end2 = null;
        while (head1 != null && head2 != null) {
            if (head1.value != head2.value) {
                return false;
            }
            end1 = head1;
            end2 = head2;
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 != null || head2 != null) {
            return false;
        }
        while (end1 != null && end2 != null) {
            if (end1.value != end2.value) {
                return false;
            }
            end1 = end1.last;
            end2 = end2.last;
        }
        return end1 == null && end2 == null;
    }

    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 100000;
        for (int i = 0; i < testTime; i++) {
            Node node1 = generateRandomList(len, value);
            Node reverse1 = reverseList(node1);
            Node back1 = testReverseNode(reverse1);
            if (!checkLinkedListEqual(node1, back1)) {
                System.out.println("oops!");
                break;
            }
            DoubleNode node2 = generateRandomDoubleList(len, value);
            DoubleNode reverse2 = reverseDoubleNode(node2);
            DoubleNode back2 = testReverseDoubleNode(reverse2);
            if (!checkDoubleListEqual(node2, back2)) {
                System.out.println("oops!");
                break;
            }
        }
        System.out.println("finish!");
    }
}
