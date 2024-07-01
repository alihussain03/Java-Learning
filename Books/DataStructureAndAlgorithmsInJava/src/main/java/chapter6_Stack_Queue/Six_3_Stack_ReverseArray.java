package chapter6_Stack_Queue;

import java.util.Arrays;

public class Six_3_Stack_ReverseArray {
    public static void main(String[] args) {

        Integer[] a = {4, 8, 15, 16, 23, 42};
        String[] s = {"Jack", "Kate", "Hurley", "Jin", "Michael"};
        reverse(a);
        reverse(s);
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
    }

    public static <E> void reverse(E[] a) {
        Six_2_Stack_Using_LinkedList stack = new Six_2_Stack_Using_LinkedList();
        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = (E) stack.pop();
        }
    }
}
