package testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Collection Test Suite")

public class CollectionTestSuite {

    private OddNumbersExterminator exterminator;

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
        exterminator = new OddNumbersExterminator();
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("sprawdzający, czy klasa zachowuje się poprawnie, gdy lista jest pusta")
    @Test
    void testOddNumbersExterminatorEmptyList() {

        List<Integer> data = Collections.emptyList();

        List<Integer> result = exterminator.exterminate(data);

        assertEquals(Collections.emptyList(), result);
    }

    @DisplayName("sprawdzający, czy klasa zachowuje się poprawnie, gdy lista zawiera liczby parzyste i nieparzyste")
    @Test
    void testOddNumbersExterminatorNormalList() {

        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> result = exterminator.exterminate(data);

        assertEquals(Arrays.asList(2, 4, 6, 8), result);
    }
}
