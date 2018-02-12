package py.com.cracking.code.interview;

import java.util.Hashtable;

public class DoubleLink {

    public static void main(String[] args) {
        DoubleLink app = new DoubleLink();
        Node list = app.get();
        Node nList = app.copyList(list);

        app.display(list);
        app.display(nList);
    }

    private static class Node implements Cloneable {
        int data;

        Node next;
        Node nnext;

        Node(int data) {
            this.data = data;
        }

        @Override
        public Node clone() {
            Node n = new Node(this.data);

            return n;
        }

        @Override
        public String toString() {
            return  data + "[" + (nnext != null ? nnext.data : "-") + "]-> ";
        }
    }

    Node get() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        b.nnext = d;
        c.nnext = a;
        e.nnext = f;
        f.nnext = e;

        return a;
    }

    void display(Node head) {
        System.out.print("\nList: ");

        Node t = head;
        while (t != null) {
            System.out.print(t);
            t = t.next;
        }
        System.out.println();
    }

    Node copyList(Node head) {
        Node t = head;
        Node prev = null;
        Hashtable<Node, Node> table = new Hashtable<>();

        while (t != null) {
            Node newNode = t.clone();
            table.put(t, newNode);
            if (prev != null) {
                table.get(prev).next = newNode;
            }
            prev = t;
            t = t.next;
        }

        t = head;
        while (t != null) {
            Node cloned = table.get(t);
            if (t.nnext != null) {
                cloned.nnext = table.get(t.nnext);
            }
            t = t.next;
        }

        Node headNode = table.get(head);
        table.clear();
        return headNode;
    }

}
