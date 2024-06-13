package edu.escuelaing.arsw.ase.app;

/**
 * LinkedList Class
 */
public class LinkedList<T> {
    private Node<T> head;

    /**
     * Class implementation of Node<T>
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        /**
         * Constructor of Node
         * @param data
         */
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public boolean remove(T data) {
        if (head == null) return false;
        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }
        return false;
    }

    public T get(int index) {
        Node<T> current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println();
    }

    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
