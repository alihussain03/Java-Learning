package chapter6_Stack_Queue;

public interface Six_5_Queue<E>{
    int size();

    boolean isEmpty();

    void enqueue(E e);

    E first();

    E dequeue();
}
