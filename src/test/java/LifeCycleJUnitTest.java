import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LifeCycleJUnitTest {

    @BeforeEach
    void setUp() {

        System.out.println("Перед каждым тестом");
    }

    @AfterEach
    void tearDown() {

        System.out.println("После каждого теста");
    }

    @BeforeAll
    void setUpAll() {

        System.out.println("Перед всеми тестами");
    }

    @AfterAll
    void tearDownAll() {

        System.out.println("After all the tests");
    }

    @Test
    @DisplayName("the first")
    @Order(1)
    void first() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum);
        System.out.println("The first test passed");
    }

    @Test
    @DisplayName("The second")
    void second() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum);
        System.out.println("The second test passed");
    }
}