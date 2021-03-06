package mx.com.dxesoft;

import mx.com.dxesoft.lists.CycleList;

import java.util.Scanner;

import static mx.com.dxesoft.BalancedBraketsChar.isBalanced;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
//        cycleList();

//        balancedBrackets();

//        myQueue();

        BinarySearchTree binarySearchTree = new BinarySearchTree();

        BinarySearchTree.Node arbol = binarySearchTree.new Node();
//        BinarySearchTree.Node arbol2 = new BinarySearchTree().new Node();

        arbol.data =5;
        creaArbol(arbol, 2, 6);
        creaArbol(arbol.left, 1, 3);

        creaArbol(arbol.right,4, 7);
        creaArbol(arbol.right.right, 5,8);

        System.out.println(binarySearchTree.checkBST(arbol));
        System.out.println(binarySearchTree.checkBST(null));


    }

    private static void myQueue() {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        queue.enqueue(42);
        queue.dequeue();
        queue.enqueue(14);
        System.out.println(queue.peek());
        queue.enqueue(28);
        System.out.println(queue.peek());
        queue.enqueue(60);
        queue.enqueue(78);
        queue.dequeue();
        queue.dequeue();

        System.out.println(queue.peek());

        queue.dequeue();
        queue.dequeue();
    }

    private static void creaArbol(BinarySearchTree.Node arbol, int izq, int der) {
        BinarySearchTree.Node left = new BinarySearchTree().new Node();
        left.data =izq;
        arbol.left = left;
        BinarySearchTree.Node right = new BinarySearchTree().new Node();
        right.data = der;
        arbol.right = right;
    }

    private static void creaArbol(BinarySearchTree.Node arbol, int val) {
//        BinarySearchTree.Node left = new BinarySearchTree().new Node();
//        left.data = val;
//        arbol.left = left;
        BinarySearchTree.Node right = new BinarySearchTree().new Node();
        right.data = val;
        arbol.right = right;
    }

    private static void balancedBrackets() {

        System.out.println(isBalanced("{"));
        System.out.println(isBalanced("{}["));
        System.out.println(isBalanced("))))){{}}}}}}"));
        System.out.println(isBalanced("{{}}}}}}"));
        System.out.println(isBalanced("{[(r)]}{{}}                 "));
        System.out.println(isBalanced("{[](){[()]}}}"));
        System.out.println(isBalanced("{{[[(( ))]]}}"));
        System.out.println(isBalanced("{{{}{{{{{{{{{{mi mamama me {{{{{{{{{{{{{{{{{{{{{{{{{{mima{{{{{{tes tristes{{{{{{{{{{{{{tigres{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{"));
        System.out.println(isBalanced("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{(lkjlueue){{{{{{{{{{{{{{{{{{{{ssss{{{{{{eee{{{{{{{{{{{{{{{{{{{{{{{{{{{{[[[[[[[[[[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]]]]]]]]}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}"));
    }

    private static void cycleList() {
        CycleList cycleList = new CycleList();

        CycleList.Node<Integer> head = cycleList.new Node<>(0);

        generalista(cycleList, head, false);
//        generalista(cycleList, head, true);

        System.out.println(cycleList.hasCycle(head));
    }

    private static void generalista(CycleList cycleList, CycleList.Node<Integer> head, boolean circular) {
        CycleList.Node<Integer> tmp = head;
        CycleList.Node<Integer> aux = null;

        for (int i = 1; i < 3; i++) {

            tmp = adelante(tmp, i, cycleList);

            if (i == 1) {
                aux = tmp;
            }

        }

        if(circular) {
            tmp.setNext(aux);
        }
    }

    public static CycleList.Node<Integer> adelante(CycleList.Node head, int val, CycleList cycleList) {
        CycleList.Node<Integer> node = cycleList.new Node<>(val);

        head.setNext(node);

        return node;
    }
}
