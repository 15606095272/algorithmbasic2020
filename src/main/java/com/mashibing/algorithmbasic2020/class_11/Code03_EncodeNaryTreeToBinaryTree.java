package com.mashibing.algorithmbasic2020.class_11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linshijin
 * @date 2022/4/21 16:36
 */
public class Code03_EncodeNaryTreeToBinaryTree {

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Codec {
        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if (root == null) {
                return null;
            }
            TreeNode treeNode = new TreeNode(root.val);
            treeNode.left = en(root.children);
            return treeNode;
        }

        private TreeNode en(List<Node> list) {
            TreeNode head = null;
            TreeNode cur = null;
            for (Node node : list) {
                TreeNode treeNode = new TreeNode(node.val);
                if (head == null) {
                    head = treeNode;
                } else {
                    cur.left = treeNode;
                }
                cur = treeNode;
                cur.left = en(node.children);
            }
            return head;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if (root == null) {
                return null;
            }
            return new Node(root.val, de(root.left));
        }

        private List<Node> de(TreeNode root) {
            List<Node> children = new ArrayList<>();
            while (root != null) {
                Node cur = new Node(root.val, de(root.left));
                children.add(cur);
                root = root.right;
            }
            return children;
        }
    }
}
