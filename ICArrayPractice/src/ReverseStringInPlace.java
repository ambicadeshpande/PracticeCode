import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class ReverseStringInPlace {

    public static void reverse(char[] arrayOfChars) {
        System.out.println(arrayOfChars);
        int j = arrayOfChars.length - 1;
        char tempChar;
        // reverse input array of characters in place

        for (int i = 0; i < arrayOfChars.length/2; i++){
            //do nothing as of now
            //swap elements
            if (i != j) {
                tempChar = arrayOfChars[i];
                arrayOfChars[i] = arrayOfChars[j];
                arrayOfChars[j] = tempChar;
                j = j - 1;
            }
        }
        System.out.println(arrayOfChars);
    }

    // tests

    @Test
    public void emptyStringTest() {
        final char[] actual = "".toCharArray();
        reverse(actual);
        final char[] expected = "".toCharArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void singleCharacterStringTest() {
        final char[] actual = "A".toCharArray();
        reverse(actual);
        final char[] expected = "A".toCharArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void longerStringTest() {
        final char[] actual = "ABCDE".toCharArray();
        reverse(actual);
        final char[] expected = "EDCBA".toCharArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void evenElementsStringTest() {
        final char[] actual = "ABHG".toCharArray();
        reverse(actual);
        final char[] expected = "GHBA".toCharArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void veryLongStringTest() {
        final char[] actual = "ABCDEFGHIJK".toCharArray();
        reverse(actual);
        final char[] expected = "KJIHGFEDCBA".toCharArray();
        assertArrayEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ReverseStringInPlace.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}