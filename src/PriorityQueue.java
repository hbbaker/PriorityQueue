/**
 * Implementation of a PriorityQueue class via an implicit heap structure.
 * The structure uses an ArrayList to dynamically resize itself and is generally
 * more flexible than a standard array, which is useful for this academic project.
 *
 * @author Henry Baker
 * @version 2023.09.25
 */

import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueue<E> {

    /**
     * Helper class object that holds the data to be
     * stored and the priority of that data in the
     * PriorityQueue.
     */
    private class Node {
        private final E data;
        private int priority;

        /**
         * Constructor for Node
         *
         * @param inputObj Element to be stored.
         * @param score int priority of that element.
         */
        public Node(E inputObj, int score) {
            data = inputObj;
            priority = score;
        }

        /**
         * Accessor method for data.
         * @return Data stored in Node.
         */
        public E getData() {
            return data;
        }

        /**
         * Accessor for Node priority.
         *
         * @return int priority of Node
         */
        public int getPriority() {
            return priority;
        }

    }

    // Global Vars
    private ArrayList<Node> queueHeap;
    private boolean hiFirst = false;


    // Constructors

    /**
     * Default constructor creates a PriorityQueue that prioritizes 0-base
     * as the maximum priority value.
     */
    public PriorityQueue() {
        queueHeap = new ArrayList<Node>();
    }

    /**
     * Constructor that creates a PriorityQueue that prioritizes higher
     * priority values higher.
     *
     * @param highFirst
     */
    public PriorityQueue(boolean highFirst) {
        queueHeap = new ArrayList<Node>();
        hiFirst = highFirst;
    }

    //Public PriorityQueue methods

    /**
     * Adds an element to the priority queue at the specified priority value.
     *
     * @param object Element to be added to the queue.
     * @param score int priority of the element to be added.
     */
    public void add(E object, int score) {
        // Create new node with object and score
        Node newNode = new Node(object, score);
        // Add node to queueHeap
        queueHeap.add(newNode);
        // swim() node into correct heap order
        swim();
    }

    /**
     * Clears the priority queue.
     */
    public void clear() {
        queueHeap = null;
        queueHeap = new ArrayList<Node>();
    }

    /**
     * Returns the size of the priority queue.
     *
     * @return int size of the priority queue.
     */
    public int size() {
        return queueHeap.size();
    }

    /**
     * Returns whether the queue contains the specified element.
     *
     * @param object Object to check if contains.
     * @return Boolean if queue contains element.
     */
    public boolean contains(E object) {
        for(Node n : queueHeap) {
            if(n.getData() == object) { // Make sure that you can use == method for comparison
                return true;
            }
        }
        return false;
    }

    /**
     * Removes and returns the element of highest priority in the queue.
     *
     * @return Element of highest priority in the queue.
     */
    public E getNext() {
        // swap head and end, sink head, end in temp var, remove end, return temp
        Node temp = queueHeap.get(0);
        int size = queueHeap.size()-1;
        swap(0, size);
        queueHeap.remove(size);
        sink();
        return temp.getData();
    }

    /**
     * Returns if priority queue is empty.
     *
     * @return Boolean if queue is empty.
     */
    public boolean isEmpty() {
        return queueHeap.isEmpty();
    }

    /**
     * Returns the element in the queue with the highest priority
     * without removing it from the list.
     *
     * @return Element of highest priority.
     */
    public E peek() {
        return queueHeap.get(0).getData();
    }

    /**
     * Removes a specified object from the queue
     * Only removes the first occurrence in the list.
     *
     * @param object Object to be removed from the list.
     * @return Boolean if removal is successful.
     */
    public boolean remove(E object) {
        for(Node n: queueHeap) {
            if (n.getData() == object) {
                queueHeap.remove(n);
                return true;
            }
        }
        return false;
    }

    /**
     * The toString method creates a printable list of all elements in the queue.
     *
     * @return String list of all elements in the priority queue.
     */
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

    // Private Heap-related methods
    // Sinking and Swimming insights found at: https://mathcenter.oxford.emory.edu/site/cs171/sinkAndSwim/

    // *************************
    //
    //  Sink() method moves top index down through the heap data structure in order to maintain
    //  heap structure property on a getNext() call.
    //  Additional info on how swim() works is provided in the code.
    //
    // *************************
    private void sink() {
        // heap sink() function, called when removing from the PQ
        // Start at index 0
        int i = 0;

        // While the left child index is leq to the last index of the arrayList
        while(((2*i)+1) <= queueHeap.size()-1){

            // Start with left child
            int j = (2*i)+1;

            // If the left child is less than the last index (then a right child must exist)
            // && the left child is NOT higher priority, then set j to the index of right child
            if(j < queueHeap.size()-1 && !compare(queueHeap.get(j), queueHeap.get(j+1))) {
                j++;
            }
            // if winning child is lower priority than current parent, break and don't swap
            if(compare(queueHeap.get(i), queueHeap.get(j))) {
                break;
            }
            // Otherwise, swap the elements and set the new parent index to the winning child containing sinking node
            swap(j, i);
            i = j;

        }
    }

    // *************************
    //
    //  Swim() func takes a Node added to last element of queueHeap
    //  and moves it up through the tree structure to maintain heap structure
    //  property on an add() call.
    //
    // *************************
    private void swim() {
        // heap swim function, called when inserting to the PQ

        int i = queueHeap.size()-1;

        // While node is not the root
        while (i > 0) {
            // Get parent index
            int j = (i-1)/2;
            // if the current index of swimming item is higher priority,
            if(compare(queueHeap.get(i),queueHeap.get(j))) {
                // then swap it with its parent
                swap(i, j);
                // Set the swimming index counter to that of its parent
                i = j;
            } else {
                break;
            }
        }
    }

    // *************************
    //
    //  Swaps nodes at index i and j of the queueHeap.
    //
    // *************************
    private void swap(int i, int j) {
        Collections.swap(queueHeap, i, j);
    }

    // *************************
    //
    //  Returns boolean Node a greater priority than Node b
    //  By default, compare() returns true for 0 being max priority.
    //  If hiFirst is true, then higher value priority is true.
    //
    // *************************
    private boolean compare(Node a, Node b) {
        if(hiFirst) {
            return (a.getPriority() > b.getPriority());
        }
        return (a.getPriority() < b.getPriority());
    }
}
