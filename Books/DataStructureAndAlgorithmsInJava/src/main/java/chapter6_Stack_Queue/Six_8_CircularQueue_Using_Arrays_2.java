package chapter6_Stack_Queue;

import java.lang.reflect.Array;

public class Six_8_CircularQueue_Using_Arrays_2<T> {
    private static final int SPECIAL_EMPTY_VALUE = -1;
    private static int MAX_SIZE = 40;
    private T[] elements;

    private int headIndex = SPECIAL_EMPTY_VALUE;
    private int tailIndex = SPECIAL_EMPTY_VALUE;

    public Six_8_CircularQueue_Using_Arrays_2(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    public Six_8_CircularQueue_Using_Arrays_2(Class<T> clazz, int size) {
        elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
    }

    public void enqueue(T data) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }
        tailIndex = (tailIndex + 1) % elements.length;
        elements[tailIndex] = data;

        // This is the first element enqueued, set the head index
        // to the tail index.
        if (headIndex == SPECIAL_EMPTY_VALUE) {
            headIndex = tailIndex;
        }
    }

    public boolean offer(T data) {
        if (isFull()) {
            return false;
        }
        try {
            enqueue(data);
        } catch (QueueOverflowException qoe) {
            // Ignore, this should never happen, we've checked
            // for a full queue already.
        }

        return true;
    }


    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        T data = elements[headIndex];
        // This was the last element in the queue.
        if (headIndex == tailIndex) {
            headIndex = SPECIAL_EMPTY_VALUE;
        } else {
            headIndex = (headIndex + 1) % elements.length;
        }
        return data;
    }

    public boolean isEmpty() {
        return headIndex == SPECIAL_EMPTY_VALUE;
    }

    public boolean isFull() {
        int nextIndex = (tailIndex + 1) % elements.length;

        return nextIndex == headIndex;
    }

    public T peek() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        return elements[headIndex];
    }

    public static class QueueOverflowException extends Exception {
    }

    public static class QueueUnderflowException extends Exception {
    }

    public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException {
        MAX_SIZE = 4;
        Six_8_CircularQueue_Using_Arrays_2<Integer> queue = new Six_8_CircularQueue_Using_Arrays_2<>(Integer.class);

        System.out.println("Queue full?: " + queue.isFull());
        System.out.println("Queue empty?: " + queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Queue full?: " + queue.isFull());
        System.out.println("Queue empty?: " + queue.isEmpty());

        queue.enqueue(4);
        System.out.println("Queue full?: " + queue.isFull());
        System.out.println("Queue empty?: " + queue.isEmpty());

        System.out.println("Queue peek: " + queue.peek());

        int data = queue.dequeue();
        System.out.println("Dequeued element: " + data);

        System.out.println("Peek : " + queue.peek());

        data = queue.dequeue();
        System.out.println("Dequeued element: " + data);
        System.out.println("Peek : " + queue.peek());

        try {
            queue.enqueue(4);
            queue.enqueue(5);
            queue.enqueue(6);
        } catch (QueueOverflowException soe) {
            System.out.println("Queue is full! No room available.");
        }

        try {
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
        } catch (QueueUnderflowException sue) {
            System.out.println("Queue is empty! No elements available.");
        }

    }

}
