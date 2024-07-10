import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue_Using_Array<Item> implements Iterable<Item> {
    private static final int INIT_CAPACITY = 8;

    private Item[] data;
    private int size;
    private int first;
    private int last;

    public Queue_Using_Array() {
        data = (Item[]) new Object[INIT_CAPACITY];
        size = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        assert capacity >= size;
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = data[(first + i) % data.length];
        }
        data = copy;
        first = 0;
        last = size;
    }

    public void enqueue(Item item) {
        if (size == data.length) resize(2 * data.length);
        data[last++] = item;
        if (last == data.length) last = 0;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = data[first];
        data[first] = null;
        size--;
        first++;
        if (first == data.length) first = 0;
        // shrink size of array if necessary
        if (size > 0 && size == data.length / 4) resize(data.length / 2);
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return data[first];
    }

    public static void main(String[] args) {
        Queue_Using_Array<String> queue = new Queue_Using_Array<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }


    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() {
            return i < size;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = data[(i + first) % data.length];
            i++;
            return item;
        }
    }
}
