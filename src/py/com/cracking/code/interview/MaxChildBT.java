package py.com.cracking.code.interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxChildBT {

    private int max = 0;
    private static final double LOG_2 = Math.log(2);
    private Map<Integer, Integer> childrenSize = new HashMap<>();

    public static void main(String[] args) {
        MaxChildBT app = new MaxChildBT();
        Node root = app.getTree();
        System.out.println("Solved " + app.getMax(root) + "-" + app.levelOrderSize(root));
        app.levelOrder(root);

    }

    private void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.print(n.data + " ");
            if (n.left != null) queue.add(n.left);
            if (n.right != null) queue.add(n.right);
        }
    }

    private int levelOrderSize(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int s = 0;
        while (!queue.isEmpty()) {
            s = Math.max(s, queue.size());
            for (int i = 0; i < queue.size(); i++) {
                Node n = queue.poll();
                System.out.print(n.data + " ");
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
        }
        return s;
    }

    int getMax(Node root) {
        solve(root, 1);
        return max;
    }

    private void solve(Node node, int p) {
        if (node == null) {
            return;
        }

        int index = log2(p);
        Integer d = childrenSize.get(index);
        if (d == null) {
            d = 0;
        }
        d++;
        max = Math.max(max, d);
        childrenSize.put(index, d);
        solve(node.left, 2*p);
        solve(node.right, 2*p +1);
    }

    public static int log2(int n) {
        return (int)(Math.log(n) / LOG_2);
    }

    Node getTree() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine  = new Node(9);
        Node ten  = new Node(10);
        Node fourteen  = new Node(14);
        Node fifteen  = new Node(15);

        four.left = eight;
        four.right = nine;

        five.left = ten;
        seven.left = fourteen;
        seven.right = fifteen;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        one.left = two;
        one.right = three;

        return one;
    }


    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int n) {
            data = n;
        }
    }
}
