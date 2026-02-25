package exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecondChallengeTestSuite {

    private SecondChallenge secondChallenge;

    @BeforeEach
    void before() {
        secondChallenge = new SecondChallenge();
    }

    @Test
    void shouldReturnDoneWhenXInRangeAndYNot() throws Exception {
        String result = secondChallenge.probablyIWillThrowException(1.0, 1.4);
        assertEquals("Done!", result);
    }

    @Test
    void shouldThrowExceptionWhenXEquals2() {
        secondChallenge = new SecondChallenge();
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 1.4));
    }

    @Test
    void shouldThrowExceptionWhenXGreaterThan2() {
        secondChallenge = new SecondChallenge();
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.000001, 1.4));
    }

    @Test
    void shouldThrowExceptionWhenYEquals1point5() {
        secondChallenge = new SecondChallenge();
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.2, 1.5));
    }
}
