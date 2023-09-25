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
            score = priority;
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
        // Check highFirst and grab from top or bottom depending on which priority is requested
        return null;
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
        StringBuilder queueString = new StringBuilder("[ ");

        for(int i = 0; i < queueHeap.size(); i++){
            if(i == queueHeap.size()-1) {
                queueString.append("("+ queueHeap.get(i).getData()+", "+queueHeap.get(i).getPriority()+") ");
            } else {
                queueString.append("("+ queueHeap.get(i).getData()+", "+queueHeap.get(i).getPriority()+"), ");
            }

        }
        queueString.append(" ]");
        return queueString.toString();
    }

    //Private Heap-related methods
    private void sink(ArrayList<E> list) {
        // heap sink() function, called when removing from the PQ

    }

    private void swim(ArrayList<E> list) {
        // heap swim function, called when inserting to the PQ
    }

    private void swap(int i, int j) {
        Collections.swap(queueHeap, i, j);
    }
}
