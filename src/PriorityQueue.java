/**
 *
 */

import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueue<E> {
    private class Node {
        private final E data;
        private int priority;

        public Node(E inputObj, int score) {
            data = inputObj;
            priority = score;
        }

        public E getData() {
            return data;
        }

        public int getPriority() {
            return priority;
        }

    }

    // Global Vars
    private ArrayList<Node> queueHeap;
    private boolean hiFirst = false;


    // Constructors
    public PriorityQueue() {
        queueHeap = new ArrayList<Node>();
    }

    public PriorityQueue(boolean highFirst) {
        queueHeap = new ArrayList<Node>();
        hiFirst = highFirst;
    }

    //Public PriorityQueue methods
    public void add(E object, int score) {
        // Create new node with object and score
        Node newNode = new Node(object, score);
        // Add node to queueHeap
        queueHeap.add(newNode);
        // swim() node into correct heap order
        swim();
    }

    public void clear() {
        queueHeap = null;
        queueHeap = new ArrayList<Node>();
    }

    public int size() {
        return queueHeap.size();
    }

    public boolean contains(E object) {
        for(Node n : queueHeap) {
            if(n.getData() == object) { // Make sure that you can use == method for comparison
                return true;
            }
        }
        return false;
    }

    public E getNext() {
        // swap head and end, sink head, end in temp var, remove end, return temp
        Node temp = queueHeap.get(0);
        int size = queueHeap.size()-1;
        swap(0, size);
        queueHeap.remove(size);
        sink();
        return temp.getData();
    }

    public boolean isEmpty() {
        return queueHeap.isEmpty();
    }

    public E peek() {
        return null;
    }

    public boolean remove(E object) {
        return false;
    }

    public String toString() {
        StringBuilder queueString = new StringBuilder("[");
        int queueSize = queueHeap.size();

        for(int i = 0; i < queueSize; i++){
            if(i == queueSize-1) {
                queueString.append("("+ queueHeap.get(i).getData()+", "+queueHeap.get(i).getPriority()+")");
            } else {
                queueString.append("("+ queueHeap.get(i).getData()+", "+queueHeap.get(i).getPriority()+"), ");
            }

        }
        queueString.append("]");
        return queueString.toString();
    }

    //Private Heap-related methods
    // Sinking and Swimming insights found at: https://mathcenter.oxford.emory.edu/site/cs171/sinkAndSwim/
    private void sink() {
        // heap sink() function, called when removing from the PQ
        int i = 0;

        while(((2*i)+1) <= queueHeap.size()-1){

            int j = (2*i)+1;
            if(j < queueHeap.size()-1 && compare(queueHeap.get(j), queueHeap.get(j+1))) {
                j++;
            }
            if(compare(queueHeap.get(j), queueHeap.get(i))) {
                break;
            }
            swap(j, i);
            i = j;

        }
    }

    private void swim() {
        // heap swim function, called when inserting to the PQ

        int i = queueHeap.size()-1;

        while (i > 0) {
            int j = (i-1)/2;
            if(compare(queueHeap.get(i),queueHeap.get(j))) {
                swap(i, j);
                i = j;
                //System.out.println(i);
            } else {
                //System.out.println("No swap, i= "+i);
                break;
            }
        }
    }

    private void swap(int i, int j) {
        Collections.swap(queueHeap, i, j);
    }

    private boolean compare(Node a, Node b) {
        // Check this logic once sink and swim are implemented, this could be wrong
        if(hiFirst) {
            return (a.getPriority() > b.getPriority());
        }
        return (a.getPriority() < b.getPriority());
    }
}
