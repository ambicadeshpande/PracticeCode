import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class FlightMovieLength {

    public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {

        int movieLen = movieLengths.length - 1;
        if (movieLengths.length == 1 && movieLengths.length == flightLength) {
            return true;
        }
        // determine if two movies add up to the flight length
        for (int i = 0; i < movieLen; i++) {
            for (int j = 1; j <= movieLen; j++) {
                int sum = movieLengths[i] + movieLengths[j];

                if ( sum == flightLength) {
                    return true;
                }
            }
        }
        return false;
    }

     //tests

     @Test
     public void shortFlightTest() {
         final boolean result = canTwoMoviesFillFlight(new int[] {2, 4}, 1);
         assertFalse(result);
     }

    @Test
    public void longFlightTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {2, 4}, 6);
        assertTrue(result);
    }

     @Test
     public void onlyOneMovieHalfFlightLenghtTest() {
         final boolean result = canTwoMoviesFillFlight(new int[] {3, 8}, 6);
         assertFalse(result);
     }

     @Test
     public void twoMoviesHalfFlightLengthTest() {
         final boolean result = canTwoMoviesFillFlight(new int[] {3, 8, 3}, 6);
         assertTrue(result);
     }

     @Test
     public void lotsOfPossiblePairsTest() {
         final boolean result = canTwoMoviesFillFlight(new int[] {1, 2, 3, 4, 5, 6}, 7);
         assertTrue(result);
     }

     @Test
     public void notUsingFirstMovieTest() {
         final boolean result = canTwoMoviesFillFlight(new int[] {4, 3, 2}, 5);
         assertTrue(result);
     }

    @Test
    public void oneMovieTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {6}, 6);
        assertFalse(result);
    }

    @Test
    public void noMoviesTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {}, 6);
        assertFalse(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FlightMovieLength.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}