/*
 * StringExamples.java
 *
 * Version:
 *  1
 *
 * Revision:
 *  1
 */

/**
 * Utility class StringExample1 to show String object creation.
 */
public class StringExample1 {
    /**
     * program entry point main method.
     *
     * @param args
     */
    public static void main( String[] args ) {


//        int[] test = new int[]{3, 4, 4, 5, 7};
//        for (int idx = 0; idx < test.length; idx++) {
//            System.out.println(test[idx]);
//        }
        // creating a string object from constant
        String s1 = "abc";
        String s2 = "abd";
        // print s1
        System.out.println(s1);
        // print s2, it is empty
        System.out.println(s2);
        // apply s1 replace method to create a new string
        String s3 = s1.replace('c', 'd');
        System.out.println( s3.contains("c") );
        System.out.println(s3);
        System.out.println(s2);
        System.out.println(s1);
        System.out.println(s2.equals(s3));
        return;
    }
}
