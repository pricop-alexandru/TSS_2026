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
    void shouldDetectInvalidTriangleWhenSideIsZeroOrNegative() {
        assertFalse(TriangleClassifier.isValidTriangle(0, 5, 5));
        assertFalse(TriangleClassifier.isValidTriangle(-1, 4, 4));
        assertEquals(TriangleType.INVALID, TriangleClassifier.classify(0, 5, 5));
        assertEquals(AngleType.INVALID, TriangleClassifier.classifyByAngle(-1, 4, 4));
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
}
