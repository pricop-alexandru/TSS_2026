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
        assertEquals(AngleType.ACUTE, TriangleClassifier.classifyByAngle(5, 5, 5));
        assertEquals(10.825317547305483, TriangleClassifier.area(5, 5, 5), 0.0001);
        assertEquals(15, TriangleClassifier.perimeter(5, 5, 5));
        assertEquals(4.3301270189, TriangleClassifier.height(5, 5, 5), 0.0001);
    }

    @Test
    void shouldThrowExceptionWhenSideIsZeroOrNegative() {
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.classify(0, 5, 5));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.classify(-1, 4, 4));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.classifyByAngle(0, 5, 5));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.isRightTriangle(0, 3, 4));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.isObtuseTriangle(-1, 3, 4));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.isAcuteTriangle(-1, 3, 4));
    }

    @Test
    void shouldThrowExceptionWhenSideBIsZeroOrNegative() {
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.classify(5, 0, 5));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.classify(-4, -1, 5));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.classifyByAngle(5, 0, 5));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.isRightTriangle(3, 0, 4));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.isObtuseTriangle(3, -1, 4));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.isAcuteTriangle(3, -1, 4));
    }

    @Test
    void shouldThrowExceptionWhenSideCIsZeroOrNegative() {
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.classify(5, 5, 0));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.classify(-4, 5, -1));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.classifyByAngle(5, 5, 0));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.isRightTriangle(3, 4, 0));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.isObtuseTriangle(3, 4, -1));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.isAcuteTriangle(4, 5, -1));
    }

    @Test
    void shouldDetectInvalidTriangleWhenSideIsZeroOrNegative() {
        assertFalse(TriangleClassifier.isValidTriangle(0, 5, 5));
        assertFalse(TriangleClassifier.isValidTriangle(5, 0, 5));
        assertFalse(TriangleClassifier.isValidTriangle(5, 5, 0));
        assertFalse(TriangleClassifier.isValidTriangle(-1, 4, 4));
        assertFalse(TriangleClassifier.isValidTriangle(4, -1, 4));
        assertFalse(TriangleClassifier.isValidTriangle(4, 4, -1));
        assertEquals(TriangleType.INVALID, TriangleClassifier.classify(1, 2, 10));
        assertEquals(AngleType.INVALID, TriangleClassifier.classifyByAngle(1, 2, 10));
    }

    @Test
    void shouldDetectInvalidTriangleForInequalityViolation() {
        assertFalse(TriangleClassifier.isValidTriangle(1, 2, 10));
        assertFalse(TriangleClassifier.isValidTriangle(2, 3, 5));
        assertEquals(TriangleType.INVALID, TriangleClassifier.classify(1, 2, 10));
        assertEquals(TriangleType.INVALID, TriangleClassifier.classify(2, 3, 5));
    }

    @Test
    void shouldRejectInvalidTriangleWhenSumOfTwoSidesEqualsThirdInAnyOrder() {
        assertFalse(TriangleClassifier.isValidTriangle(2, 3, 5));
        assertFalse(TriangleClassifier.isValidTriangle(2, 5, 3));
        assertFalse(TriangleClassifier.isValidTriangle(5, 2, 3));
        assertEquals(TriangleType.INVALID, TriangleClassifier.classify(2, 3, 5));
        assertEquals(TriangleType.INVALID, TriangleClassifier.classify(2, 5, 3));
        assertEquals(TriangleType.INVALID, TriangleClassifier.classify(5, 2, 3));
    }

    @Test
    void shouldRecognizeRightTriangleForUnsortedSideOrder() {
        assertTrue(TriangleClassifier.isRightTriangle(5, 3, 4));
        assertEquals(AngleType.RIGHT, TriangleClassifier.classifyByAngle(5, 4, 3));
        assertEquals(TriangleType.RIGHT_SCALENE, TriangleClassifier.classify(4, 3, 5));
    }

    @Test
    void shouldComputeSemiperimeterForValidTriangle() {
        assertEquals(6.0, TriangleClassifier.semiperimeter(3, 4, 5), 0.0001);
    }

    @Test
    void shouldClassifyIsoscelesTriangle() {
        assertEquals(TriangleType.ISOSCELES, TriangleClassifier.classify(5, 5, 7));
        assertEquals(AngleType.ACUTE, TriangleClassifier.classifyByAngle(5, 5, 7));
        assertEquals(17, TriangleClassifier.perimeter(5, 5, 7));
    }

    @Test
    void shouldClassifyRightScaleneTriangle() {
        assertTrue(TriangleClassifier.isRightTriangle(3, 4, 5));
        assertEquals(AngleType.RIGHT, TriangleClassifier.classifyByAngle(3, 4, 5));
        assertEquals(TriangleType.RIGHT_SCALENE, TriangleClassifier.classify(3, 4, 5));
    }

    @Test
    void shouldClassifyScaleneAndAngleTypes() {
        assertEquals(TriangleType.SCALENE, TriangleClassifier.classify(4, 5, 6));
        assertTrue(TriangleClassifier.isAcuteTriangle(4, 5, 6));
        assertEquals(AngleType.ACUTE, TriangleClassifier.classifyByAngle(4, 5, 6));
    }

    @Test
    void shouldClassifyObtuseTriangle() {
        assertEquals(AngleType.OBTUSE, TriangleClassifier.classifyByAngle(2, 3, 4));
        assertTrue(TriangleClassifier.isObtuseTriangle(2, 3, 4));
        assertEquals(TriangleType.SCALENE, TriangleClassifier.classify(2, 3, 4));
    }

    @Test
    void shouldComputeHeightAndAreaForValidTriangle() {
        assertEquals(6.0, TriangleClassifier.area(3, 4, 5), 0.0001);
        assertEquals(2.4, TriangleClassifier.height(3, 4, 5), 0.0001);
    }

    @Test
    void shouldThrowWhenComputingAreaForInvalidTriangle() {
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.area(1, 1, 3));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.height(1, 1, 3));
        assertThrows(IllegalArgumentException.class, () -> TriangleClassifier.semiperimeter(1, 1, 3));
    }

    @Test
    void shouldHandleExtremeCasesWithMinimalValues() {
        // Minimal equilateral triangle: (1, 1, 1)
        assertEquals(TriangleType.EQUILATERAL, TriangleClassifier.classify(1, 1, 1));
        assertEquals(AngleType.ACUTE, TriangleClassifier.classifyByAngle(1, 1, 1));
        assertEquals(1.5, TriangleClassifier.semiperimeter(1, 1, 1), 0.0001);
        assertEquals(3, TriangleClassifier.perimeter(1, 1, 1));
        
        // Minimal scalene: (3, 4, 5)
        assertEquals(TriangleType.RIGHT_SCALENE, TriangleClassifier.classify(3, 4, 5));
        assertEquals(6.0, TriangleClassifier.area(3, 4, 5), 0.0001);
    }

    @Test
    void shouldHandleExtremeCasesWithMaximalValues() {
        // Large equilateral triangle: (500, 500, 500)
        assertEquals(TriangleType.EQUILATERAL, TriangleClassifier.classify(500, 500, 500));
        assertEquals(AngleType.ACUTE, TriangleClassifier.classifyByAngle(500, 500, 500));
        assertEquals(750, TriangleClassifier.semiperimeter(500, 500, 500), 0.0001);
        
        // Large isosceles: (500, 500, 400)
        assertEquals(TriangleType.ISOSCELES, TriangleClassifier.classify(500, 500, 400));
        assertEquals(1400, TriangleClassifier.perimeter(500, 500, 400));
        
        // Large scalene: (100, 101, 102)
        assertEquals(TriangleType.SCALENE, TriangleClassifier.classify(100, 101, 102));
        assertTrue(TriangleClassifier.isAcuteTriangle(100, 101, 102));
    }

    @Test
    void shouldHandleAlmostDegenerateTriangles() {
        // Nearly degenerate (sum equals third in boundary): (2, 3, 4) should be SCALENE
        assertEquals(TriangleType.SCALENE, TriangleClassifier.classify(2, 3, 4));
        
        // Just above degenerate: (2, 3, 4) should be valid
        assertTrue(TriangleClassifier.isValidTriangle(2, 3, 4));
        
        // Just below degenerate: (1, 2, 3) should be invalid
        assertFalse(TriangleClassifier.isValidTriangle(1, 2, 3));
    }
}