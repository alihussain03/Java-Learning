package chapter3_Array_LinkedList;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Three_2_ScoreBoard scoreBoard = new Three_2_ScoreBoard(3);
        scoreBoard.add(new Three_1_GameEntry("Java", 3));
        scoreBoard.add(new Three_1_GameEntry("Java", 4));
        scoreBoard.add(new Three_1_GameEntry("Java", 5));
        scoreBoard.add(new Three_1_GameEntry("Java", 8));

        scoreBoard.remove(0);

        Arrays.stream(scoreBoard.getBoard()).forEach(gameEntry -> {
            if (gameEntry != null) {
                // System.out.println(gameEntry.getScore());
            }
        });

        System.out.println("-----------Start of Singly linked list---------------------");

        Three_7_SinglyLinkedList<Object> singlyLinkedList = new Three_7_SinglyLinkedList<>();
        singlyLinkedList.addFirst("Hello");
        singlyLinkedList.addFirst("world");
        singlyLinkedList.addFirst("java");
        singlyLinkedList.addLast("Last");

        System.out.println("Singly list size is "+singlyLinkedList.size());
        singlyLinkedList.printList();

        Three_7_SinglyLinkedList<Object> singlyLinkedList1 = new Three_7_SinglyLinkedList<>();
        singlyLinkedList1.addFirst("Hello");
        singlyLinkedList1.addFirst("world");
        singlyLinkedList1.addFirst("java");
        singlyLinkedList1.addLast("Last1");

        // singlyLinkedList.removeFirst();
        System.out.println("Lists are equal ? "+singlyLinkedList1.equals(singlyLinkedList));
        System.out.println("\n");
        System.out.println("-----------Start of Doubly linked list---------------------");

        Three_9_DoublyLinkedList<Object> doublyLinkedList = new Three_9_DoublyLinkedList<>();
        doublyLinkedList.addFirst("Add first ");
        doublyLinkedList.addLast("Add Last ");
        doublyLinkedList.addLast("Add Last 1");
        doublyLinkedList.addBefore("Add before", 1);

        System.out.println(doublyLinkedList.size());
        System.out.println(doublyLinkedList.isEmpty());
        System.out.println(doublyLinkedList.last());
        System.out.println(doublyLinkedList.first());

        doublyLinkedList.printList();
    }
}
