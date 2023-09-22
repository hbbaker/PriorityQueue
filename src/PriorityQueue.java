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
        Node newNode = new Node(object, score);
        // Add node to queueHeap
        queueHeap.add(newNode);
        // heapify() to ensure accuracy

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
        StringBuilder queueString = new StringBuilder("[ ");
        for(Node node:queueHeap) {
            queueString.append("("+ node.getData()+", "+node.getPriority()+")");
        }
        queueString.append(" ]");
        return queueString.toString();
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
