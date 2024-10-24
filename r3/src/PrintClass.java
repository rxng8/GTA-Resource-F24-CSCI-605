/**
 * StyleExample serves as an example of recommended Java coding style.
 *
 * @author Anne Author, axa1234@rit.edu
 * @author Sumhel Per, spp1234@rit.edu
 */

class SingleInteger {
    private int myInteger;

    public SingleInteger(int number) {
        this.myInteger = number;
    }

    /**
     * Object toString
     * public String toString() {
     *      return getClass().getName() + "@" + Integer.toHexString(hashCode());
     * }
     */
    @Override // overriding toString method in the object class
    public String toString() {
        String objectString = super.toString();
        return objectString + " | My Integer is " + Integer.toString(myInteger);
    }
}

public class PrintClass {
    public static void main(String[] args) {
        SingleInteger myInteger = new SingleInteger(4);
        System.out.println(myInteger.toString());
//        Object o = new Object();
//        System.out.println(o);
    }
}
