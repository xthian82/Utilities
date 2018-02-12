package py.com.snowtech.datastructure.lists;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int size;

    public void enqueue(T data) {
        Node n = new Node(data);

        if (first == null) {
            first = n;
        }

        if (last != null) {
            last.next = n;
        }

        last = n;

        ++size;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        --size;
        T tmpData = first.data;
        first = first.next;
        return tmpData;
    }

    public boolean isEmpty() {
        return  size == 0;
    }

    public void display() {
        System.out.print("Queue (" + size + "): ");
        Iterator<T> it = this.iterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T tData = current.data;
            current = current.next;
            return tData;
        }
    }

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.display();
        queue.dequeue();
        queue.display();
        queue.dequeue();
        queue.display();
    }

}
