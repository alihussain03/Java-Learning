package chapter3;

public class DoublyLinkedList<E> {
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
        trailer.setPrev(header);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public void addBefore(E e, int index) {

        Node tempNode = header.getNext();
        int i = 0;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Check out of bounds");
        }
        while (i < index) {
            tempNode = tempNode.getNext();
            i++;
        }

        addBetween(e, tempNode.getPrev(), tempNode);

    }

    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    private E remove(Node<E> prev) {
        Node<E> predecessor = prev.getPrev();
        Node<E> successor = prev.getNext();
        predecessor.setNext(successor);
        successor.setNext(predecessor);
        size--;
        return prev.getElement();
    }

    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public void printList() {
        Node print = header;
        while (print.getNext() != null) {
            if (print.getElement() != null)
                System.out.println(print.getElement());
            print = print.getNext();
        }
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

}
