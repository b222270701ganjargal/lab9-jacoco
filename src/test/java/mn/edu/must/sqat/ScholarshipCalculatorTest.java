
package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calculator = new ScholarshipCalculator();

    @Test
    void letterGradeA() {
        assertEquals("A", calculator.letterGrade(95));
    }

    @Test
    void letterGradeB() {
        assertEquals("B", calculator.letterGrade(85));
    }

    @Test
    void gpaNormal() {
        assertEquals(3.5, calculator.gpa(new double[]{95, 85}), 0.001);
    }

    @Test
    void scholarshipFull() {
        assertEquals(100, calculator.scholarship(3.9, 16, false));
    }

    @Test
    void scholarshipPartial() {
        assertEquals(70, calculator.scholarship(3.5, 13, false));
    }
    
    @Test
    void scholarshipNegativeGpaThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(-0.1, 15, false));
    }

    @Test
    void scholarshipGpaAboveFourThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(4.1, 15, false));
    }

    @Test
    void scholarshipNegativeCreditsThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(3.5, -1, false));
    }

    @Test
    void scholarshipWithViolationReturnsZero() {
        assertEquals(0, calculator.scholarship(3.9, 16, true));
    }

    @Test
    void scholarshipFiftyPercent() {
        assertEquals(50, calculator.scholarship(3.2, 12, false));
    }

    @Test
    void letterGradeRemainingCases() {
        assertEquals("C", calculator.letterGrade(75));
        assertEquals("D", calculator.letterGrade(65));
        assertEquals("F", calculator.letterGrade(50));
    }

    @Test
    void letterGradeInvalidScores() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.letterGrade(-1));
        assertThrows(IllegalArgumentException.class,
                () -> calculator.letterGrade(101));
    }

    @Test
    void gpaInvalidArrays() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(null));
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(new double[]{}));
    }

    @Test
    void gpaAllGradeBranches() {
        assertEquals(2.0,
                calculator.gpa(new double[]{95, 85, 75, 65, 50}),
                0.001);
    }

    @Test
    void scholarshipNoAward() {
        assertEquals(0, calculator.scholarship(2.5, 15, false));
    }

    @Test
    void scholarshipHighGpaLowCredits() {
        assertEquals(50, calculator.scholarship(3.9, 10, false));
        assertEquals(50, calculator.scholarship(3.5, 10, false));
    }

    @Test
    void gpaSingleElement() {
        assertEquals(4.0, calculator.gpa(new double[]{95}), 0.001);
    }

    @Test
    void gpaMultipleElements() {
        assertEquals(2.5, calculator.gpa(new double[]{95, 85, 75, 65}), 0.001);
    }

    @Test
    void letterGradeSixtyShouldBeD() {
        assertEquals("D", calculator.letterGrade(60));
    }

@Test
void letterGradeBoundaryValues() {
    assertEquals("F", calculator.letterGrade(0));
    assertEquals("F", calculator.letterGrade(59.99));
    assertEquals("D", calculator.letterGrade(69.99));
    assertEquals("C", calculator.letterGrade(70));
    assertEquals("C", calculator.letterGrade(79.99));
    assertEquals("B", calculator.letterGrade(80));
    assertEquals("B", calculator.letterGrade(89.99));
    assertEquals("A", calculator.letterGrade(90));
    assertEquals("A", calculator.letterGrade(100));
}


}
