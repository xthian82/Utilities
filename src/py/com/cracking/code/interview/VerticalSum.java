package py.com.cracking.code.interview;

public class VerticalSum {

    private int[] vertical;

    public static void main(String[] args) {
        Node root = getTree();
        VerticalSum app = new VerticalSum();
        app.calculate(root);
        app.display();

    }

    void calculate(Node root) {
        int totalLeft = 0;
        int totalRight = 0;
        Node t = root.left;
        while (t != null) {
            t = t.left;
            ++totalLeft;
        }
        t = root.right;
        while (t != null) {
            t = t.right;
            ++totalRight;
        }
        int middle = Math.max(totalLeft, totalRight) + 1;
        vertical = new int [1 + totalLeft + totalRight];
        sum(root, middle);
    }

    void sum(Node n, int index) {
        if (n == null) {
            return;
        }
        vertical[index - 1] += n.data;
        sum(n.left, index - 1);
        sum(n.right, index + 1);
    }

    void display() {
        System.out.print("VSum: ");
        for (int i = 0; i < vertical.length; i++) {
            System.out.print(vertical[i] + " ");
        }
        System.out.println();
    }

    static Node getTree() {
        Node root = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        three.left = seven;
        three.right = six;

        two.left = four;
        two.right = five;

        root.left = two;
        root.right = three;
        return root;
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

}

//  1 2 3 4 5 6 7
//0 1 2 3 4 5 7 6


// left = 1 2 4
// right =  3 6

// 1
// 2 3
// 4 6