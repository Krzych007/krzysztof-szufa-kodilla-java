package array;

import com.kodilla.stream.array.ArrayOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {

        int[] numbers = new int[] {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
        };

        double average = ArrayOperations.getAverage(numbers);

        Assertions.assertEquals(10.5, average, 0.001);
    }
}
