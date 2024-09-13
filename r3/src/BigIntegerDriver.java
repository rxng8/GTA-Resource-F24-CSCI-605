import java.math.BigInteger;

public class BigIntegerDriver {

    // Returns Factorial of N
    static BigInteger factorial(int N) {
        // Initialize result
        BigInteger result = BigInteger.ONE; // Static variable
        // Multiply f with 2, 3, ...N
        for (int i = 2; i <= N; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }


    public static void main(String[] args) {

        int a, b;
        BigInteger A, B;
        a = 54;
        b = 23;
        A  = BigInteger.valueOf(54);
        // B  = BigInteger.valueOf(127361729639812730817203); // this will not work
        A  = new BigInteger("54");
        B  = new BigInteger("123456789123456789");

        System.out.println(A.multiply(B));
        System.out.println(A.add(B));

    }
}
