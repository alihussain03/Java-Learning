package chapter6_Stack_Queue;

import chapter3_Array_LinkedList.Three_7_SinglyLinkedList;

public class Six_8_Queue_Using_LinkedList<E> implements Six_6_QueueInterface<E> {

    Three_7_SinglyLinkedList<E> list = new Three_7_SinglyLinkedList<>();

    public static void main(String[] args) {
        System.out.println("Queue using LinkedList");
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }
}
