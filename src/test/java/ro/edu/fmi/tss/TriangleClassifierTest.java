package ro.edu.fmi.tss;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TriangleClassifierTest {

    @Test
    void shouldClassifyEquilateralTriangle() {
        assertEquals(TriangleType.EQUILATERAL, TriangleClassifier.classify(5, 5, 5));
        assertEquals(10.825317547305483, TriangleClassifier.area(5, 5, 5), 0.0001);
        assertEquals(15, TriangleClassifier.perimeter(5, 5, 5));
    }

    @Test
    void shouldDetectInvalidTriangleWhenALeZero() {
        assertFalse(TriangleClassifier.isValidTriangle(0, 5, 5));
        assertEquals(TriangleType.INVALID, TriangleClassifier.classify(0, 5, 5));
    }

    @Test
    void shouldDetectInvalidTriangleForInequalityViolation() {
        assertFalse(TriangleClassifier.isValidTriangle(1, 2, 10));
        assertEquals(TriangleType.INVALID, TriangleClassifier.classify(1, 2, 10));
    }

    @Test
    void shouldClassifyIsoscelesTriangle() {
        assertEquals(TriangleType.ISOSCELES, TriangleClassifier.classify(5, 5, 7));
        assertEquals(17, TriangleClassifier.perimeter(5, 5, 7));
    }

    @Test
    void shouldClassifyRightScaleneTriangle() {
        assertTrue(TriangleClassifier.isRightTriangle(3, 4, 5));
        assertEquals(TriangleType.RIGHT_SCALENE, TriangleClassifier.classify(3, 4, 5));
    }

    @Test
    void shouldReturnScaleneForDistinctNonRightTriangle() {
        assertEquals(TriangleType.SCALENE, TriangleClassifier.classify(4, 5, 6));
    }

    @Test
    void shouldThrowWhenComputingAreaForInvalidTriangle() {
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.area(1, 1, 3));
    }
}
