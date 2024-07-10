import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue_Using_LinkedList<Item> implements Iterable<Item> {
    private int size;
    private Node firstNode;
    private Node lastNode;

    private class Node {
        private Item item;
        private Node next;
    }

    public Queue_Using_LinkedList() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public int size() {
        return size;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return firstNode.item;
    }

    public void enqueue(Item item) {
        Node oldlast = lastNode;
        lastNode = new Node();
        lastNode.item = item;
        lastNode.next = null;
        if (isEmpty()) firstNode = lastNode;
        else oldlast.next = lastNode;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = firstNode.item;
        firstNode = firstNode.next;
        size--;
        if (isEmpty()) lastNode = null;   // to avoid loitering
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node current = firstNode;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue_Using_LinkedList<String> queue = new Queue_Using_LinkedList<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                queue.enqueue(item);
            else if (!queue.isEmpty())
                StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }


}
