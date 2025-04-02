import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LifeCycleJUnitTest {

    @BeforeEach
    void setUp() {
        // Здесь размещаем код подготовки перед каждым тестом
        System.out.println("Перед каждым тестом");
    }

    @AfterEach
    void tearDown() {
        // Здесь размещаем код очистки после каждого теста
        System.out.println("После каждого теста");
    }

    @BeforeAll
    void setUpAll() {
        // Here we palace the preparation code before all tests
        System.out.println("Перед всеми тестами");
    }

    @AfterAll
    void tearDownAll() {
        // Here we post the cleanup code after all tests
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