package interviewq.veryhard;

import java.util.HashMap;
import java.util.Map;


public class Q_LRUCache {

    static class DoublyLinkedListNode<T> {
        DoublyLinkedListNode<T> next;
        DoublyLinkedListNode<T> prev;
        final T key;
        int value;

        public DoublyLinkedListNode(T key, int value) {
            this.key = key;
            this.value = value;
        }

        public void removeBindingsFromExistingList() {
            //to remove a node make the previous node point to current->next
            if (prev != null) {
                prev.next = next;
            }

            //to remove a node make the next node point to current->prev
            if (next != null) {
                next.prev = prev;
            }

            // and clean the node for better GC
            prev = null;
            next = null;
        }
    }

    static class DoublyLinkedList<T> {
        DoublyLinkedListNode<T> head;
        DoublyLinkedListNode<T> tail;

        // newly accessed value is moved to first node in DLL as most recently used
        void moveToHead(DoublyLinkedListNode<T> node) {
            if (node == null || node == head) {
                return;
            }

            if (head == null) {
                head = tail = node;
            } else if (head == tail) {
                // only one node
                tail.prev = node;
                head = node;
                head.next = tail;
            } else {
                if (tail == node) {
                    removeFromTail();
                }

                node.removeBindingsFromExistingList();

                // add to head
                head.prev = node;
                node.next = head;
                head = node;
            }
        }

        // the first one should always be most recently used, so in a linked list removing it is really fast
        void removeFromTail() {
            if (tail == null) {
                return;
            }

            // only 1 node
            if (tail == head) {
                head = tail = null;
                return;
            }

            tail = tail.prev;   // update tail
            tail.next = null;   // new tail point to null now
        }

        private void print() {
            DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(head.key, head.value);
            node.next = head.next;
            while (node.next != null) {
                System.out.print(node.key + "(" + node.value + ")->");
                node = node.next;
            }
            System.out.println(node.key + "(" + node.value + ")");
        }
    }

    static class LRUCache<T> {
        final int maxSize;
        final Map<T, DoublyLinkedListNode<T>> keysMap;
        final DoublyLinkedList<T> doublyLinkedList = new DoublyLinkedList<>();

        LRUCache(int maxSize) {
            this.maxSize = Math.max(maxSize, 1);
            this.keysMap = new HashMap<>(maxSize);
        }

        public void insertKeyValuePair(T key, int value) {
            DoublyLinkedListNode<T> node = keysMap.get(key);
            if (node == null) {
                if (keysMap.size() == maxSize) {
                    // evictLeastRecent
                    final T evictLeastRecent = doublyLinkedList.tail.key;
                    keysMap.remove(evictLeastRecent);
                    doublyLinkedList.removeFromTail();
                }

                System.out.print("INSERT {" + key + "}: ");
                node = new DoublyLinkedListNode<>(key, value);
                keysMap.put(key, node);
            } else {
                // key already there, so we only update the value -> remove it from DLL
                // no need to update the cache as we can only replace the value
                System.out.print("UPDATE {" + key + "}: ");
                node.value = value;
            }

            // put the latest in beginning
            doublyLinkedList.moveToHead(node);
            doublyLinkedList.print();
        }

        public LRUResult getValueFromKey(T key) {
            System.out.print("ACCESS {" + key + "}: ");

            final DoublyLinkedListNode<T> node = keysMap.get(key);

            if (node == null) {
                System.out.println("NOT_FOUND");
                return new LRUResult(false, -1);
            } else {
                // remove from existing position ??
                doublyLinkedList.moveToHead(node);
                doublyLinkedList.print();
                return new LRUResult(true, node.value);
            }
        }

        public T getMostRecentKey() {

            // if there are no keys return null
            if (keysMap.isEmpty()) {
                return null;
            }

            // else return the head key
            return doublyLinkedList.head.key;
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        @Override
        public String toString() {
            return "LRUResult{" +
                    "found=" + found +
                    ", value=" + value +
                    '}';
        }

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }
}

// static class LRUCache {
//    int maxSize;
//
//    public LRUCache(int maxSize) {
//      this.maxSize = maxSize > 1 ? maxSize : 1;
//    }
//
//    public void insertKeyValuePair(String key, int value) {
//      // Write your code here.
//    }
//
//    public LRUResult getValueFromKey(String key) {
//      // Write your code here.
//      return null;
//    }
//
//    public String getMostRecentKey() {
//      // Write your code here.
//      return null;
//    }
//  }

//static class LRUCacheBad {
//    private final int maxSize;
//    private final Deque<Map.Entry<String, Integer>> cache = new LinkedList<>();
//
//    public LRUCacheBad(int maxSize) {
//        this.maxSize = Math.max(maxSize, 1);
//    }
//
//    /**
//     * add entry to cache
//     * but if an existing key is updated we can either update the value and swap it to the end
//     * or simply remove the existing key and add the new key
//     * O(n) for finding the existing key and O(1) for insert/delete
//     *
//     * @param key
//     * @param value
//     */
//    public void insertKeyValuePair(String key, int value) {
//
//        final var entry = Map.entry(key, value);
//        if (cache.size() == maxSize) {
//            cache.removeFirst();
//        }
//
//        final var existingVal = cache.stream()
//                .filter(e -> e.getKey().equals(key))
//                .findFirst();
//        existingVal.ifPresent(cache::remove);
//
//        // the remove method already has a contains so - if the exact key is present we move it to the last
//        cache.remove(entry);
//        cache.addLast(entry);
//    }
//
//    /**
//     * get value from key - no deletion from cache here as well
//     *
//     * @param key the key to be searched
//     * @return
//     */
//    public Q_LRUCache.LRUResult getValueFromKey(String key) {
//
//        System.out.println(cache);
//        final var result = cache.stream()
//                .filter(entry -> entry.getKey().equals(key))
//                .findFirst();
//
//        return result.map(e -> {
//            cache.remove(e);
//            cache.addLast(e);
//            return new Q_LRUCache.LRUResult(true, e.getValue());
//        }).orElse(new Q_LRUCache.LRUResult(false, -1));
//    }
//
//    /**
//     * Just return the last element which we are making sure always be the latest
//     * we are not deleting it just yet as this is just seek
//     *
//     * @return
//     */
//    public String getMostRecentKey() {
//        return cache.getLast().getKey();
//    }
//}