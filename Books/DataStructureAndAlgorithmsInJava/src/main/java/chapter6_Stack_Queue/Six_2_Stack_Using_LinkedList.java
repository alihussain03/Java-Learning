package chapter6_Stack_Queue;

import chapter3_Array_LinkedList.Three_7_SinglyLinkedList;

public class Six_2_Stack_Using_LinkedList<E> implements Six_0_Stack<E>{
    private final Three_7_SinglyLinkedList<E> list = new Three_7_SinglyLinkedList<>();

    public Six_2_Stack_Using_LinkedList() {
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E e) {
       list.addFirst(e);
    }

    public E peek() {
        return (E) list.first();
    }

    public E pop() {
        return (E) list.removeFirst();
    }

    public static void main(String[] args) {
        Six_2_Stack_Using_LinkedList<Object> stack = new Six_2_Stack_Using_LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();
        System.out.println(stack.peek());
    }

    public static class StackOverflowException extends Exception {
    }

    public static class StackUnderflowException extends Exception {
    }

}
