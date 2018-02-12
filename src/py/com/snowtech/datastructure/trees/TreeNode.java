package py.com.snowtech.datastructure.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class TreeNode {

    private int value;
    private TreeNode left;
    private TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    int LCA(int left, int right) {
        Deque<Integer> leftPath = new ArrayDeque<>();
        Deque<Integer> rightPath = new ArrayDeque<>();

        path(this, left, leftPath);
        path(this, right, rightPath);

        //print(leftPath);
        //print(rightPath);
        int lca = -1;
        while (!leftPath.isEmpty() && !rightPath.isEmpty()) {
            if (leftPath.peekFirst() == rightPath.peekFirst()) {
                lca = leftPath.pollFirst();
                rightPath.pollFirst();
            } else {
                break;
            }

        }

        return lca;
    }

    private void print(Queue<Integer> path) {
        System.out.println("====================");
        path.forEach(p -> System.out.print(p + " "));
        System.out.println();

    }


    /*
     * static Deque<Integer> pathToX(TreeNode root, int value) { if (root == null) { return null; }
     * 
     * if (root.value == value) { Deque<Integer> arr = new ArrayDeque<>(); arr.add(root.value); return arr; }
     * Deque<Integer> leftPath = pathToX(root.left, value); if (leftPath != null) { leftPath.add(root.value); return
     * leftPath; } Deque<Integer> rightPath = pathToX(root.right, value); if (rightPath != null) { rightPath.add(value);
     * return rightPath; } return null; }
     */

    boolean path(TreeNode root, int value, Deque<Integer> path) {
        if (root == null)
            return false;

        path.add(root.value);
        if (root.value == value) {

            return true;
        }

        boolean found = path(root.left, value, path) || path(root.right, value, path);
        // System.out.println("" + found + "=" + (root.left != null ?root.left.value:"") + "," + (root.right != null ?
        // root.right.value : ""));
        if (!found) {
            path.pop();
        }
        return found;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(0);

        n6.left = n5;
        n3.left = n4;
        n3.right = n6;

        n2.left = n7;
        n2.right = n8;
        n1.left = n3;
        n1.right = n2;

        /*
         * System.out.println("4,-1: " + n1.LCA(4, -1)); System.out.println("4,1: " + n1.LCA(4, 1));
         * System.out.println("4,5: " + n1.LCA(4, 5)); System.out.println("3,5: " + n1.LCA(3, 5));
         * System.out.println("4,7: " + n1.LCA(4, 7)); System.out.println("3,7: " + n1.LCA(3, 7));
         */ System.out.println("6,7: " + n1.LCA(6, 7)); 
         System.out.println("6,6: " + n1.LCA(6, 6));
         
        System.out.println("0,7: " + n1.LCA(0, 7));

    }
}
