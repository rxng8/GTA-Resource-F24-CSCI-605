
class MyObject {
    public int myInt = -1;
    public MyObject(int num) {
        myInt = num;
    }

    @Override
    public String toString() {
        return "[MyObject]: " + myInt;
    }
}

public class Passing {

    static void changeVal(int x) {
        // pass by value/ pass by copy
        /**
         * Modifying it inside the method does
         * not affect the original variable.
         */
        x = 42;
    }

    static void changeRef(String x) {
        // Pass by reference
        /**
         * Since strings are immutable, you can't
         * change the actual string, but you can
         * change the reference to point to a different string.
         */
        x = "changed!";
    }

    static void changeRef(int[] arr) {
        // Pass by reference
        /**
         * you can modify the contents of the array,
         * and those changes will be reflected outside
         * the method, but reassigning the array reference
         * inside the method won't affect the original array.
         */
        arr = new int[]{42, 42, 42};
    }

    static void changeVal(int[] arr) {
        // Pass by reference
        /**
         * you can modify the contents of the array,
         * and those changes will be reflected outside
         * the method, but reassigning the array reference
         * inside the method won't affect the original array.
         */
        arr[0] = 42;
    }

    static void changeRef(MyObject obj) {
        // Pass by reference
        /**
         * If you modify the object via this reference,
         * the change will affect the original object.
         * However, if you reassign the reference inside
         * the method, it won't affect the original reference.
         */
        obj = new MyObject(42);
    }

    static void changeVal(MyObject obj) {
        // Pass by reference
        /**
         * If you modify the object via this reference,
         * the change will affect the original object.
         * However, if you reassign the reference inside
         * the method, it won't affect the original reference.
         */
        obj.myInt = 42;
    }

    static String arrString(int[] arr) {
        String s = "[";
        for (int x: arr) {
            s += (x + ", ");
        }
        return s.substring(0, s.length() - 2) + "]";
    }

    public static void main(String[] args) {
        int x1;
        x1 = 0;
        System.out.println("[Before changing] x1: " + x1);
        changeVal(x1);
        System.out.println("[After changing] x1: " + x1);

        String x2;
        x2 = "hello";
        System.out.println("[Before changing] x2: " + x2);
        changeRef(x2);
        System.out.println("[After changing] x2: " + x2);

        int[] arr1;
        arr1 = new int[]{0, 0, 0};
        System.out.println("[Before changing] arr1: " + arrString(arr1));
        changeRef(arr1);
        System.out.println("[After changing] arr1: " + arrString(arr1));

        int[] arr2;
        arr2 = new int[]{0, 0, 0};
        System.out.println("[Before changing] arr2: " + arrString(arr2));
        changeVal(arr2);
        System.out.println("[After changing] arr2: " + arrString(arr2));

        MyObject obj1 = new MyObject(0);
        System.out.println("[Before changing] obj1: " + obj1.toString());
        changeRef(obj1);
        System.out.println("[After changing] obj1: " + obj1.toString());

        MyObject obj2 = new MyObject(0);
        System.out.println("[Before changing] obj2: " + obj2.toString());
        changeVal(obj2);
        System.out.println("[After changing] obj2: " + obj2.toString());

    }
}
