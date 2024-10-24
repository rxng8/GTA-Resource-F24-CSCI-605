import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static boolean checkPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Method 1: simple to code, brute force, and very slow
     public static int palindromeIndex(String s) {
         if (checkPalindrome(s)) return -1;

         for (int i = 0; i < s.length(); i++) {
             String removedS = s.substring(0, i) + s.substring(i + 1, s.length());
             if (checkPalindrome(removedS)) return i;
         }

         return -1;
     }

     // Method 2: more complicated, but more efficient
//    public static int palindromeIndex(String s) {
//
//        int left;
//        int right;
//
//        // remove character from the left pointer
//        int storedIndexLeft = -1;
//        left = 0;
//        right = s.length() - 1;
//        boolean usedRemovalLeft = false;
//        while (left < right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                if (!usedRemovalLeft && s.charAt(left + 1) == s.charAt(right)) {
//                    storedIndexLeft = left;
//                    left++;
//                    usedRemovalLeft = true;
//                } else {
//                    storedIndexLeft = -1;
//                    break;
//                }
//            }
//            left++;
//            right--;
//        }
//
//        // remove character from the left pointer
//        int storedIndexRight = -1;
//        left = 0;
//        right = s.length() - 1;
//        boolean usedRemovalRight = false;
//        while (left < right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                if (!usedRemovalRight && s.charAt(left) == s.charAt(right - 1)) {
//                    storedIndexRight = right;
//                    right--;
//                    usedRemovalRight = true;
//                } else {
//                    storedIndexRight = -1;
//                    break;
//                }
//            }
//            left++;
//            right--;
//        }
//
//        if (usedRemovalLeft && storedIndexLeft != -1) return storedIndexLeft;
//        if (usedRemovalRight && storedIndexRight != -1) return storedIndexRight;
//        return -1;
//    }

}

public class StringPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            int result = Result.palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
