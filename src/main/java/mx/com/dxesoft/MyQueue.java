package mx.com.dxesoft;

/**
 *
 * @see <a href="https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem">Queues: A Tale of Two Stacks</a>
 *
 * In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is one of the following  types:

 1 x: Enqueue element  into the end of the queue.
 2: Dequeue the element at the front of the queue.
 3: Print the element at the front of the queue.
 * @param <T>
 */
public class MyQueue<T> {

    private class Node<T> {

        private T value;

        private Node<T> previous;

        Node(T value) {
            this.value = value;
            this.previous = null;
        }

        T getValue() {
            return value;
        }

        void setValue(T value) {
            this.value = value;
        }

        Node<T> getPrevious() {
            return previous;
        }

        void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }

    private Node<T> head;

    private Node<T> tail;

    private int count;

    public MyQueue() {
        head = tail = null;
        count = 0;
    }

    public void enqueue(T t) {

        Node<T> node = new Node<>(t);

        if (null == head) {
            head = node;
            tail = head;

        } else {
            tail.setPrevious(node);
            tail = node;
        }
        count ++;
    }

    public void dequeue() {
        if (count > 0) {
            if (count == 1) {
                head = tail = null;
            } else if (count == 2) {
                head = tail;
            } else {
                head = head.previous;
            }
            count --;
        }
    }

    public T peek() {
            return head.getValue();
    }
}
