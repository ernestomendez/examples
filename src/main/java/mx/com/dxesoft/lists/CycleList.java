package mx.com.dxesoft.lists;


import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem">Linked Lists: Detect a Cycle</a>
 *
 * function must return a boolean denoting whether or not there is a cycle in the list. If there is a cycle, return true; otherwise, return false.
 */
public class CycleList {

    public class Node<T> {

        private T value;

        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    private class ComplexNode<T> {
        private Node<T> node;
        private boolean visited;

        public ComplexNode(Node<T> node) {
            this.node = node;
            visited = false;
        }

        public Node<T> getNode() {
            return node;
        }

        public boolean hasNext() {
            return this.node.next != null;
        }

        public Node<T> getNext() {
            return this.node.next;
        }

    }

    public boolean hasCycle(Node<Integer> head) {

        ComplexNode<Integer> node = new ComplexNode<>(head);
        boolean isHead = true;

        Set<Integer> visitados = new HashSet<>();

        if (null != node.getNode()) {

            do {
                if (!isHead) {
                    node = new ComplexNode<>(node.getNext());
                }
                isHead = false;
                int nodeHash = node.getNode().hashCode();

                if (!visitados.add(nodeHash)) {
                    return true;
                }

            } while (node.hasNext());
        } else {
            return false;
        }

        return false;
    }

}
