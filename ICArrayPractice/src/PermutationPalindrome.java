import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;

public class PermutationPalindrome {

    public static boolean hasPalindromePermutation(String theString) {

        // track characters we've seen an odd number of times
        Set<Character> unpairedCharacters = new HashSet<>();

        for (char c: theString.toCharArray()) {
            if (unpairedCharacters.contains(c)) {
                unpairedCharacters.remove(c);
            } else {
                unpairedCharacters.add(c);
            }
        }

        // the string has a palindrome permutation if it
        // has one or zero characters without a pair
        return unpairedCharacters.size() <= 1;
    }

    // tests

    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabcbcd");
        assertTrue(result);
    }

     @Test
     public void permutationWithEvenNumberOfCharsTest() {
         final boolean result = hasPalindromePermutation("aabccbdd");
         assertTrue(result);
     }

     @Test
     public void noPermutationWithOddNumberOfChars() {
         final boolean result = hasPalindromePermutation("aabcd");
         assertFalse(result);
     }

     @Test
     public void noPermutationWithEvenNumberOfCharsTest() {
         final boolean result = hasPalindromePermutation("aabbcd");
         assertFalse(result);
     }

     @Test
     public void emptyStringTest() {
         final boolean result = hasPalindromePermutation("");
         assertTrue(result);
     }

     @Test
     public void oneCharacterStringTest() {
         final boolean result = hasPalindromePermutation("a");
         assertTrue(result);
     }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(PermutationPalindrome.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}