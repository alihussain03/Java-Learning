package chapter6_Stack_Queue;

public class Six_7_Circular_Queue_Using_Arrays<E> implements Six_6_QueueInterface<E> {

    private E[] data;
    private int front = 0;
    private int size = 0;

    public Six_7_Circular_Queue_Using_Arrays(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return data[front];
    }

    @Override
    public void enqueue(E e) {
        if (size == data.length) throw new IllegalStateException("Queue is full");
        int available = (front + size) % data.length;
        data[available] = e;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return answer;
    }

    public static void main(String[] args) {
        Six_7_Circular_Queue_Using_Arrays<Integer> circular_queue = new Six_7_Circular_Queue_Using_Arrays<Integer>(4);
        circular_queue.enqueue(11);
        circular_queue.enqueue(22);
        circular_queue.enqueue(33);
        circular_queue.enqueue(44);
        circular_queue.dequeue();
        circular_queue.dequeue();
        circular_queue.enqueue(55);
        circular_queue.dequeue();
        System.out.println(circular_queue.size);

        System.out.println(circular_queue.first());
    }
}
