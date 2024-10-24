/**
 * https://www.hackerrank.com/challenges/java-loops-i/problem?isFullScreen=true
 *
 * @author Anne Author, axa1234@rit.edu
 * @author Sumhel Per, spp1234@rit.edu
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Week1Challenge2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

//        Solution
        for (int i = 1; i <= 10; i++) {
            System.out.println(N * i);
        }

        bufferedReader.close();
    }
}

