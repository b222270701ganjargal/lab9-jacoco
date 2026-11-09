
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
}
