package mx.com.dxesoft;

import mx.com.dxesoft.lists.CycleList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
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
