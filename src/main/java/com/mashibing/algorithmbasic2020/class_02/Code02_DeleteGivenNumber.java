package com.mashibing.algorithmbasic2020.class_02;

/**
 * @author linshijin
 * @date 2022/3/2 20:25
 */
public class Code02_DeleteGivenNumber {

    public static class Node {
        private int value;

        private Node next;

        public Node(int val) {
            value = val;
        }
    }

    public static Node removeNode(Node head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
