import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionalTests {
    @BeforeEach
    void setUP() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    @BeforeAll
    static void setUpAll() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("AfterAll");
    }

    @Test
    void test() {
        System.out.println("Test");
        assertEquals(1, 1);
    }
}

