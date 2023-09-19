/**
 *
 */

import java.util.ArrayList;

public class PriorityQueue<E> {
    private class Node {
        private E data;
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
        // Add node to queueHeap
        // heapify() to ensure accuracy

    }

    public void clear() {
        queueHeap.clear();
    }

    public int size() {
        return queueHeap.size();
    }

    public E getNext() {
        // Store
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
        return null;
    }

    //Private Heap-related methods
    private void heapify(ArrayList<E> heap) {
        //Check hiFirst global, if false then lowFirst, if true then highFirst
        if(hiFirst) {
            // Run high first heapify()

        } else {
            // Run low first heapify()
        }

    }

}
