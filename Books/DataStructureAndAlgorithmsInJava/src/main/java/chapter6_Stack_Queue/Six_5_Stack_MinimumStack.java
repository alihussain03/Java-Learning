package chapter6_Stack_Queue;

//Example is not from the book
public class Six_5_Stack_MinimumStack {
    public static void main(String[] args) {
        MinimumStack minimumStack = new MinimumStack();
        minimumStack.push(2);
        minimumStack.push(4);
        minimumStack.push(10);

        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.push(1);
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.push(0);
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());

        minimumStack.pop();
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.pop();
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.pop();
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
    }

    public static class MinimumStack {
        private final Six_2_Stack_Using_LinkedList<Integer> stack = new Six_2_Stack_Using_LinkedList<>();
        private final Six_2_Stack_Using_LinkedList<Integer> minimumStack = new Six_2_Stack_Using_LinkedList<>();

        public void push(int data) {
            int min = data;
            if (!minimumStack.isEmpty()) {
                if (min > minimumStack.peek()) {
                    min = minimumStack.peek();
                }
            }
            stack.push(data);
            minimumStack.push(min);
        }

        public int pop() {
            minimumStack.pop();
            return stack.pop();
        }

        public int getMinimum() {
            return minimumStack.peek();
        }
    }
}
