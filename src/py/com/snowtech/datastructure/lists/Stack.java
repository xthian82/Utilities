package py.com.snowtech.datastructure.lists;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    private Node head;
    private int size;

    public void push(T data) {
        Node n = new Node(data, head);
        head = n;
        ++size;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T tmpData = head.data;
        head = head.next;
        --size;
        return tmpData;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    public void display() {
        System.out.print("Stack (" + size + "): ");
        Iterator<T> it = this.iterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();
    }

    private class StackIterator implements Iterator<T> {

        private Node current = head;

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

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.display();
        stack.pop();
        stack.display();
        stack.pop();
        stack.display();

    }
}
