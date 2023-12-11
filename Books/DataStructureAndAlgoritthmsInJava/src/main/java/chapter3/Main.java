package chapter3;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard(3);
        scoreBoard.add(new GameEntry("Java", 3));
        scoreBoard.add(new GameEntry("Java", 4));
        scoreBoard.add(new GameEntry("Java", 5));
        scoreBoard.add(new GameEntry("Java", 8));

        scoreBoard.remove(0);

        Arrays.stream(scoreBoard.getBoard()).forEach(gameEntry -> {
            if (gameEntry != null) {
                // System.out.println(gameEntry.getScore());
            }
        });

        System.out.println("-----------Start of Singly linked list---------------------");

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addFirst(new String("Hello"));
        singlyLinkedList.addFirst(new String("world"));
        singlyLinkedList.addFirst(new String("java"));
        singlyLinkedList.addLast(new String("Last"));

        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList<>();
        singlyLinkedList1.addFirst(new String("Hello"));
        singlyLinkedList1.addFirst(new String("world"));
        singlyLinkedList1.addFirst(new String("java"));
        singlyLinkedList1.addLast(new String("Last1"));
        // System.out.println(singlyLinkedList.size());
        // singlyLinkedList.removeFirst();
        System.out.println("Lists are equal ? "+singlyLinkedList1.equals(singlyLinkedList));
        System.out.println("\n");
        System.out.println("-----------Start of Doubly linked list---------------------");
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFirst(new String("Add first "));
        doublyLinkedList.addLast(new String("Add Last "));
        doublyLinkedList.addLast(new String("Add Last 1"));
        doublyLinkedList.addBefore(new String("Add before"), 1);

        System.out.println(doublyLinkedList.size());
        System.out.println(doublyLinkedList.isEmpty());
        System.out.println(doublyLinkedList.last());
        System.out.println(doublyLinkedList.first());

        doublyLinkedList.printList();
    }
}
