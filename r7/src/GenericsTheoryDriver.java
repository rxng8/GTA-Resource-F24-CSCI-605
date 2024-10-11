import java.util.List;

class GenericArray<T> {
    private Object[] array;  // Underlying array is of type Object[]
    private int size;

    public GenericArray(int size) {
        array = new Object[size];  // Create an Object array
        this.size = size;
    }

    public Object[] getArray() {
        return array;
    }

    // Method to set an element in the array
    public void set(int index, T value) {
        array[index] = value;  // Store the value at the index
    }

    // Method to get an element from the array
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];  // Cast the object back to type T
    }

    public int getSize() {
        return size;
    }

    // generic method printArray
    public static < E > void printArray( E[] inputArray ) {
        // Display array elements
        for(E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public void printArray() {
        // Display array elements
        for(Object element : array) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
}


public class GenericsTheoryDriver {

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;   // assume x is initially the largest

        if(y.compareTo(max) > 0) {
            max = y;   // y is the largest so far
        }

        if(z.compareTo(max) > 0) {
            max = z;   // z is the largest now
        }
        return max;   // returns the largest object
    }

    // Generic method with two types
    public static <T, U> void printPair(T first, U second) {
        System.out.println("First: " + first + ", Second: " + second);
    }


    public static void main(String[] args) {
        // Note: In Parameter type we can not use primitives like ‘int’,’char’ or ‘double’.
        // Create an array of Integer
        GenericArray<Integer> intArray = new GenericArray<>(5);
        intArray.set(0, 10);
        intArray.set(1, 20);
        System.out.println("First element: " + intArray.get(0));
        System.out.println("Second element: " + intArray.get(1));

        // Create an array of String
        GenericArray<String> strArray = new GenericArray<>(3);
        strArray.set(0, "Hello");
        strArray.set(1, "World");
        System.out.println("First element: " + strArray.get(0));
        System.out.println("Second element: " + strArray.get(1));

        // print array
        intArray.printArray();
        strArray.printArray();

        // print array using generic method
        GenericArray.printArray(intArray.getArray());
        GenericArray.printArray(strArray.getArray());

        // Bounded generics
        System.out.printf("Max of %d, %d and %d is %d\n\n",
                3, 4, 5, maximum( 3, 4, 5 ));

        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ));

        System.out.printf("Max of %s, %s and %s is %s\n","pear",
                "apple", "orange", maximum("pear", "apple", "orange"));

        // List of `"whatever" type that extends integer` objects
        List<? extends Integer> list;

        // Using different types for the parameters
        printPair(1, "One");
        printPair("Key", 12345);
        printPair(3.14, true);

    }
}