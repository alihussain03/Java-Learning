package chapter6_Stack_Queue;

//Example is not from the book
public class Six_2_Stack_Using_LinkedList_2<E> {

    private static final int MAX_SIZE = 40;
    private Element<E> top;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E e) {
        if (size == MAX_SIZE) {
            throw new IllegalStateException("Stack is full");
        }
        Element<E> newest = new Element<>(e, top);
        top = newest;
        size++;
    }

    public E pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is full");
        }
        E data = top.getElement();
        top = top.getNext();
        size--;
        return data;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public E peek() {
        if (isEmpty()) return null;
        return top.getElement();
    }

    public static void main(String[] args) {
        Six_2_Stack_Using_LinkedList_2<Integer> stack = new Six_2_Stack_Using_LinkedList_2<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        System.out.println(stack.peek());
    }

    private static class Element<E> {
        private E element;
        private Element<E> next;

        public Element(E element, Element<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Element<E> getNext() {
            return next;
        }

        public void setNext(Element<E> next) {
            this.next = next;
        }
    }
}
