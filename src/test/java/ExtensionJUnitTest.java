
import uz.kamoliddin.org.fpmi.Extensions.LifecycleExtension;
import uz.kamoliddin.org.fpmi.Extensions.ParameterExtension;
import uz.kamoliddin.org.fpmi.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtensionJUnitTest {

    @ExtendWith(LifecycleExtension.class)
    @Test
    void JunitTestWithLifecycleExtend() {
        int actualSum = 1 + 1;
        int expectedSum = 2;
        assertEquals(expectedSum, actualSum);
        System.out.println("JunitTestWithExtend");
    }

    @ExtendWith(ParameterExtension.class)
    @Test
    void JunitTestWithParameterExtend(User user) {
        assertAll(
                () -> assertEquals("John", user.getFirstName(), "No to'g'ri ism"),
                () -> assertEquals("Doe", user.getLastName(), "No to'g'ri familiya"),
                () -> assertEquals(30, user.getAge(), "No to'g'ri yosh")
        );
    }
}
