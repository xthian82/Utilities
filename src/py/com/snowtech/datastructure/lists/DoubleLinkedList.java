package py.com.snowtech.datastructure.lists;

public class DoubleLinkedList {
    private Node head;
    private Node current;
    
    private class Node {
        int value;
        Node next, prev;
        
        public Node(int value) {
            this.value = value;
            next = prev = null;
        }
    }
    
    public DoubleLinkedList() {
        head = new Node(-1);
        current = null;
    }
    
    void add(int value) {
        add(new Node(value));
    }
    
    private void add(Node n) {
        if (current == null) {
            current = n;
            head.next = n;
            n.prev = head;
        } else {
            n.prev = current;
            current.next = n;
            current = current.next;
            head.prev = current;
        }
    }
    
    void print() {
        print(head.next);
    }
    
    private void print(Node n) {
        while (n != null) {
            System.out.print(n.value + " ");
            n = n.next;
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        
        dll.print();
        dll.reverse();
        dll.print();
    }

    public void reverse() {
        if (head.next == null) return;
        
        head.next.prev = null;
        head.next = current;
        Node tmp = head;
        
        while (current != null) {
            Node tmp2 = current.prev;
            current.prev = tmp;
            current.next = tmp2;
            tmp = current;
            current = tmp2;
            head.prev = current;
        }
        
    }
}
