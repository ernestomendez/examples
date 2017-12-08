package mx.com.dxesoft;

import java.util.HashSet;
import java.util.Set;

/**
 * @See <a href="https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem">Trees: Is This a Binary Search Tree?</a>
 *
 * For the purposes of this challenge, we define a binary search tree to be a binary tree with the following ordering properties:

 The  value of every node in a node's left subtree is less than the data value of that node.
 The  value of every node in a node's right subtree is greater than the data value of that node.
 Given the root node of a binary tree, can you determine if it's also a binary search tree?

 */

public class BinarySearchTree {

    public class Node {
        int data;

        Node left;

        Node right;

    }

    private Set<Integer> numbers = new HashSet<>();

    public boolean checkBST(Node root) {
        return null != root && isBinary(root);
    }

    private boolean isBinary(Node root) {
        return null == root || validChilds(root) && isBinary(root.left) && isBinary(root.right);

    }

    private boolean validChilds(Node node) {
        boolean isValid = true;

        if(!numbers.add(node.data)) {
            return false;
        }

        if (null != node.left) {
            isValid = node.left.data < node.data;
        }
        if (null != node.right && isValid) {
            isValid = isValid && node.right.data > node.data;
        }

        return isValid;
    }
}
