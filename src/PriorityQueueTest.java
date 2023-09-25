
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        System.out.println("Empty pQueue: " + queue.toString());

        queue.add(1, 6);

        System.out.println("Size 1 pQueue: " + queue.toString());

        queue.add(2, 4);

        System.out.println("Size 2 pQueue: " + queue.toString());

        queue.add(3, 3);

        System.out.println("Size 3 pQueue: " + queue.toString());

        queue.add(4, 2);

        System.out.println("Size 4 pQueue: " + queue.toString());

        queue.clear();

        System.out.println("Cleared pQueue: " + queue.toString());

        int i = 15;

        queue.add(i, 7);

        System.out.println("Size 1 pQueue: " + queue.toString());




    }
}
