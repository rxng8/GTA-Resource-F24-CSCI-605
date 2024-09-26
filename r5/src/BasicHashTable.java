import java.util.LinkedList;

public class BasicHashTable {
    // Array of linked lists to handle collisions
    private LinkedList[] table;
    private int size;

    // Constructor
    public BasicHashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;

        // Initialize each bucket as a linked list
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList();
        }
    }

    // Hash function to compute an index for the string
    private int hash(String key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // Method to insert a string into the hash table
    public void insert(String key) {
        int index = hash(key);

        // Add the string to the appropriate linked list if it's not already present
        if (!table[index].contains(key)) {
            table[index].add(key);
            size++;
        }
    }

    // Method to check if a string exists in the hash table
    public boolean contains(String key) {
        int index = hash(key);
        return table[index].contains(key);
    }

    // Method to remove a string from the hash table
    public void remove(String key) {
        int index = hash(key);
        if (table[index].remove(key)) {
            size--;
        }
    }

    // Get the current size of the hash table
    public int getSize() {
        return size;
    }

    // Print the contents of the hash table
    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.println("Bucket " + i + ": " + table[i]);
        }
    }
    public static void main(String[] args) {
        BasicHashTable hashTable = new BasicHashTable(10);

        // Insert strings
        hashTable.insert("apple");
        hashTable.insert("banana");
        hashTable.insert("orange");

        // Check if strings exist
        System.out.println(hashTable.contains("apple"));   // true
        System.out.println(hashTable.contains("grape"));   // false

        // Remove a string
        hashTable.remove("banana");

        // Print the hash table contents
        hashTable.printTable();

        // Get the size
        System.out.println("Size: " + hashTable.getSize()); // 2
    }
}
