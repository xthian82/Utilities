package py.com.snowtech.util;

import java.util.ArrayDeque;
import java.util.Deque;

// 1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5
// 10 page faults, 2 hits
public class LRUCache<E> {

    private final Deque<E> cache;
    private int hits;
    private int faults;
    private int size;

    public LRUCache(int cacheSize) {
        cache = new ArrayDeque<>(cacheSize);
        size = cacheSize;
    }

    static LRUCache<Integer> getCache() {
        LRUCache<Integer> cache = new LRUCache<>(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);

        return cache;
    }

    static LRUCache<Integer> getCache1() {
        LRUCache<Integer> cache = new LRUCache<>(3);

        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(5);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(4);
        cache.refer(5);

        return cache;
    }

    public static void main(String[] args) {
        LRUCache<Integer> cache = getCache();
        cache.display();

        LRUCache<Integer> cache1 = getCache1();
        cache1.display();

    }

    public void refer(Object data) {
        boolean removed = cache.remove(data);
        if (!removed) {
            faults++;
        } else {
            ++hits;
        }
        if (cache.size() == size) {
            cache.removeLast();
        }
        cache.addFirst((E) data);
    }

    public void display() {
        System.out.print("Cache: ");
        for (E eData : cache) {
            System.out.print(eData + " ");
        }

        System.out.println("\nTotal faults: " + faults);
        System.out.println("Total hits: " + hits);
        System.out.println();
    }
    
}
