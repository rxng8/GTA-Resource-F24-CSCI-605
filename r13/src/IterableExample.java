import java.util.Iterator;

// Custom class that implements Iterable
class CustomCollection implements Iterable<String> {
    private String[] items;
    private int size;

    // Constructor to initialize the collection
    public CustomCollection(int capacity) {
        items = new String[capacity];
        size = 0;
    }

    // Method to add an item
    public void add(String item) {
        if (size < items.length) {
            items[size++] = item;
        } else {
            System.out.println("Collection is full!");
        }
    }

    // Method to get the size of the collection
    public int size() {
        return size;
    }

    // Implement the iterator() method
    @Override
    public Iterator<String> iterator() {
        return new CustomIterator();
    }

    // Inner class to implement the Iterator
    private class CustomIterator implements Iterator<String> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public String next() {
            return items[currentIndex++];
        }
    }
}

// Main class to test the CustomCollection
/**
 *     An Iterator is obtained from a collection that implements Iterable by calling the iterator() method.
 *     Methods in Iterator:
 *         boolean hasNext(): Checks if there are more elements to iterate.
 *         T next(): Returns the next element in the iteration.
 *         void remove() (optional): Removes the last element returned by the iterator (not all implementations support this).
 */
public class IterableExample {
    public static void main(String[] args) {
        // Create an instance of the custom collection
        CustomCollection collection = new CustomCollection(5);

        // Add items to the collection
        collection.add("Apple");
        collection.add("Banana");
        collection.add("Cherry");

        // Use a for-each loop to iterate through the collection
        System.out.println("Iterating through CustomCollection:");
        for (String item : collection) {
            System.out.println(item);
        }

        // Check the size of the collection
        System.out.println("Size of the collection: " + collection.size());
    }
}
