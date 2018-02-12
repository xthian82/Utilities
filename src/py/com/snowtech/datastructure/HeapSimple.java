package py.com.snowtech.datastructure;

import java.util.Iterator;

public class HeapSimple<T extends Comparable<T>> implements Iterable<T> {
    private T[] data;
    private int size;
    private int key;

    public HeapSimple(int capacity) {
        this.size = capacity;
        this.data = (T [])new Comparable[capacity + 1];
        this.key = 0;
    }

    boolean compareToExchange(int source, int target) {
        return data[source].compareTo(data[target]) < 0;
    }

    private void swimUp(int parentKey, int key) {
        if (parentKey < 1) {
            return;
        }
        if (compareToExchange(parentKey, key)) {
            swap(parentKey, key);
            swimUp(parentKey / 2, parentKey);
        }
    }

    // 4 8 7 6 5 3 2 1
    private void sink(int index) {
        if (index < 1 || index == key) {
            return;
        }

        int root = index;
        int j;
        while (2 * root <= key) {
            j = 2 * root;

            if (!compareToExchange(root, j)) { //data[root] >= data[j]) {
                break;
            }

            if (j + 1 <= key && compareToExchange(j, j + 1)) { // data[j] < data[j + 1]) {
                j++;
            }

            swap(root, j);
            root = j;
        }

    }

    private void swap(int s, int t) {
        T tmp = data[s];
        data[s] = data[t];
        data[t] = tmp;
    }

    public void insert(T data) {
        if (key == size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        this.data[++key] = data;
        swimUp(key / 2, key);
    }

    public void delete() {
        if (key == 0) {
            return;
        }

        swap(1, key--);
        data[key + 1] = null;
        sink(1);
    }

    public int size() {
        return this.key;
    }

    public void print() {
        System.out.print("Heap: ");
        for (int index = 1; index <= key; index++) {
            System.out.print(data[index] + " ");
        }
        System.out.println();
    }

    //8 6 7 4 5 3 2 1
    public static void main(String[] args) {
        HeapSimple<Integer> h = new HeapSimple<>(12);

        h.insert(6);
        h.insert(5);
        h.insert(3);
        h.insert(1);
        h.insert(8);
        h.insert(7);
        h.insert(2);
        h.insert(12);
        h.insert(4);
        h.print();
        h.delete();
        h.print();
    }

    @Override
    public Iterator<T> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<T> {

        private int currentKey = 1;

        @Override
        public boolean hasNext() {
            return currentKey <= key;
        }

        @Override
        public T next() {
            if (currentKey > key || key == 0) {
                throw new IllegalAccessError();
            }
            return data[currentKey++];
        }
    }
}

// 1  2 3 4 5 6 7 8 9
// 12 8 7 6 5 3 2 1 4
// --
// 8 6 7 4 5 3 2 1
