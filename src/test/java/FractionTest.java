import uz.kamoliddin.org.fpmi.Fraction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    @Test
    @Tag("Smoke")
    @DisplayName("The sum of two fractions")
    void simpleFraction() {
        Fraction first = new Fraction(1, 2);
        Fraction second = new Fraction(2, 3);
        Fraction expectedSum = new Fraction(7, 6);
        assertEquals(expectedSum, Fraction.sum(first, second), "");
    }

    @Test
    @Tag("Smoke")
    @DisplayName("The sum of two fractions with the same denominator")
    void negativeFraction() {
        Fraction first = new Fraction(1, 2);
        Fraction second = new Fraction(-2, 3);
        Fraction expectedSum = new Fraction(-1, 6);
        assertEquals(expectedSum, Fraction.sum(first, second), "The sums should be tha same");
    }

    @Test
    @Tag("Negative")
    @DisplayName("The sum of two fractions with the same denominator")
    void zeroNumFraction() {
        Fraction first = new Fraction(1, 2);
        Fraction second = new Fraction(-2, 4);
        Fraction expectedSum = new Fraction(0, 1); // 0/8 natijasida 0/1 bo'lishi mumkin
        assertEquals(expectedSum, Fraction.sum(first, second), "The sums should be tha same");
    }

    @Test
    @Tag("Negative")
    @DisplayName("The sum of two fractions with the same denominator")
    void zeroDenFraction() {
        assertThrows(ArithmeticException.class, () -> new Fraction(1, 0),
                "ArithmeticException");
    }

    @Test
    @Tag("Negative")
    @DisplayName("Overflow of the sum of two fractions")
    void longFraction() {
        Fraction first = new Fraction(1, 2);
        Fraction second = new Fraction(1, Integer.MAX_VALUE);
        assertThrows(ArithmeticException.class, () -> Fraction.sum(first, second),
                "An exception should be thrown. ArithmeticException");
    }
}
