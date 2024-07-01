package chapter6_Stack_Queue;


public class Six_1_Stack_Using_Array<E> implements Six_0_Stack<E> {
    public static final int CAPACITY = 1000;
    private final E[] data;
    private int t = -1;

    public Six_1_Stack_Using_Array() {
        this(CAPACITY);
    }

    public Six_1_Stack_Using_Array(int capacity) { // constructs stack with given capacity
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }

    public int size() {
        return (t + 1);
    }

    public boolean isEmpty() {
        return (t == -1);
    }

    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e; // increment t before storing new item
    }

    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null; // dereference to help garbage collection
        t--;
        return answer;

    }

    public static void main(String[] args) {
        System.out.println("Stack Using Array");
        Six_1_Stack_Using_Array<Integer> stack = new Six_1_Stack_Using_Array<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.out.println("Top Element is " + stack.top());

    }

}
