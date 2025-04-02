import uz.kamoliddin.org.fpmi.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleJUnitTests {
    @Test
    void simpleJUnitTest() {
        // Bu erda biz test kodini joylashtiramiz
        int actualSum = 2 + 2;
        int expectedSum = 4;
        // AssertTrue, assertFalse, assertEquals va boshqa Assertions usullaridan foydalaning
        assertEquals(expectedSum, actualSum);
    }

    @Test
    @Disabled // sinov boshlanmaydi, u hisobotga ignored sifatida kiradi
    void disabledTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum);
        System.out.println("Test");
    }

    @Test
    @DisplayName("Ikki raqamni qo'shish")
    void titleTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum);
    }

    @Test
    @Tag("smoke")
    void tagTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum, "Miqdorlar boshqacha bo'lishi kerak");
    }

    @Test
    @Tags({@Tag("defect"), @Tag("smoke")})
    @Timeout(value = 2)
    void timeoutTest() throws InterruptedException {
        Thread.sleep(2000);
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum);
    }

    @RepeatedTest(value = 3, name = "{displayName} - takrorlash {currentRepetition} из {totalRepetitions}")
    @DisplayName("Ikki raqamni qo'shish")
    void repeatedTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void assertTrueFalseTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertTrue(expectedSum == actualSum);
        assertFalse(expectedSum != actualSum);
    }

    @Test
    void exceptionTest() {
        String test = null;
        Exception thrown = assertThrows(NullPointerException.class, () -> test.length());

        Assertions.assertEquals("Cannot invoke \"String.length()\" because \"test\" is null", thrown.getMessage());
    }

    @Test
    void assertsAllTest() {
        User user = new User("John", "Doe", 30);
        assertAll(
                () -> assertEquals("John", user.getFirstName(), "No to'g'ri ism"),
                () -> assertEquals("Doe", user.getLastName(), "No to'g'ri familiya"),
                () -> assertEquals(30, user.getAge(), "No to'g'ri yosh")
        );
    }

    @Test
    void AssertAllSeparate() {
        User user = new User("John", "Doe", 30);
        assertEquals("John1", user.getFirstName(), "No to'g'ri ism");
        assertEquals("Doe2", user.getLastName(), "No to'g'ri familiya");
        assertEquals(31, user.getAge(),  "No to'g'ri yosh");
    }

    @Test
    public void first() throws Exception{
        System.out.println("FirstParallelUnitTest first() start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("FirstParallelUnitTest first() end => " + Thread.currentThread().getName());
    }

    @Test
    public void second() throws Exception{
        System.out.println("FirstParallelUnitTest second() start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("FirstParallelUnitTest second() end => " + Thread.currentThread().getName());
    }


}