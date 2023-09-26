
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        // Test print on empty List
        System.out.println("Empty pQueue: " + queue.toString());

        // Test print on 4 add()'s
        queue.add(1, 6);

        System.out.println("Size 1 pQueue: " + queue.toString());

        queue.add(2, 4);

        System.out.println("Size 2 pQueue: " + queue.toString());

        queue.add(3, 3);

        System.out.println("Size 3 pQueue: " + queue.toString());

        queue.add(4, 2);

        System.out.println("Size 4 pQueue: " + queue.toString());

        // Test clear() queue
        queue.clear();

        System.out.println("Cleared pQueue: " + queue.toString());

        // Test contains()
        int i = 15;

        queue.add(i, 7);

        boolean containsI = queue.contains(i);

        assert containsI;

        // Test size()
        queue.add(1, 5);

        queue.add(5, 3);

        assert queue.size() == 3;

        System.out.println("pQueue: " + queue.toString());

        // Test getNext();
        int j = queue.getNext();

        assert j == 5;

        System.out.println("pQueue: " + queue.toString());

        queue.add(1, 6);
        queue.add(2, 4);
        queue.add(3, 7);
        queue.add(4, 2);

        // Test peek()
        int peekInt = queue.peek();

        System.out.println("pQueue: " + queue.toString());

        assert peekInt == 4;

        // Test remove
        queue.add(4, 8);

        assert queue.remove(4);

        assert queue.remove(4);

        assert !queue.remove(4);

        assert queue.remove(3);

        assert !queue.remove(8);

        System.out.println("pQueue: " + queue.toString());

        PriorityQueue<String> stringPQ = new PriorityQueue<String>();

        stringPQ.add("World", 1);
        stringPQ.add("Hello", 0);

        System.out.println(stringPQ.toString());

        stringPQ.clear();

        stringPQ.add("C", 6);
        stringPQ.add("D", 2);
        stringPQ.add("C", 6);
        stringPQ.add("Z", 0);

        System.out.println(stringPQ.toString());

        stringPQ.getNext();

        System.out.println(stringPQ.toString());





    }
}
