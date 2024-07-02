package chapter6_Stack_Queue;

import chapter3_Array_LinkedList.Three_8_CircularLinkedList;

public class Six_10_CircularQueue<E> implements Six_9_CircularQueueInterface<E> {
    Three_8_CircularLinkedList<E> circularLinkedList = new Three_8_CircularLinkedList<>();

    @Override
    public void rotate() {
        circularLinkedList.rotate();
    }

    @Override
    public int size() {
        return circularLinkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return circularLinkedList.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        circularLinkedList.addFirst(e);
    }

    @Override
    public E first() {
        return circularLinkedList.first();
    }

    @Override
    public E dequeue() {
        return circularLinkedList.removeFirst();
    }
}
