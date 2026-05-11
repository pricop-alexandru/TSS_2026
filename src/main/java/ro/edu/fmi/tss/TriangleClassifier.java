package ro.edu.fmi.tss;

import java.util.Arrays;

/**
 * Utility class for classifying triangles based on side lengths.
 * Provides methods for classifying triangles by type (equilateral, isosceles, etc.)
 * and by angle (acute, right, obtuse), as well as computing geometric properties.
 */
public class TriangleClassifier {

    private TriangleClassifier() {
        // Utility class
    }

    /**
     * Classifies a triangle based on its side lengths.
     *
     * @param a the first side length
     * @param b the second side length
     * @param c the third side length
     * @return the TriangleType classification (EQUILATERAL, ISOSCELES, SCALENE, RIGHT_SCALENE, or INVALID)
     * @throws IllegalArgumentException if any side is <= 0
     */
    public static TriangleType classify(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Triangle sides must be positive (> 0)");
        }
        if (!isValidTriangle(a, b, c)) {
            return TriangleType.INVALID;
        }

        if (a == b && b == c) {
            return TriangleType.EQUILATERAL;
        }

        if (isRightTriangle(a, b, c)) {
            return TriangleType.RIGHT_SCALENE;
        }

        if (a == b || a == c || b == c) {
            return TriangleType.ISOSCELES;
        }

        return TriangleType.SCALENE;
    }

    /**
     * Classifies a triangle by its angle type.
     *
     * @param a the first side length
     * @param b the second side length
     * @param c the third side length
     * @return the AngleType classification (ACUTE, RIGHT, OBTUSE, or INVALID)
     * @throws IllegalArgumentException if any side is <= 0
     */
    public static AngleType classifyByAngle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Triangle sides must be positive (> 0)");
        }
        if (!isValidTriangle(a, b, c)) {
            return AngleType.INVALID;
        }

        int[] sides = sortSides(a, b, c);
        int x = sides[0];
        int y = sides[1];
        int z = sides[2];
        int sumOfSquares = x * x + y * y;
        int squareOfHypotenuse = z * z;

        int comparison = Integer.compare(sumOfSquares, squareOfHypotenuse);
        AngleType[] angleMap = {AngleType.OBTUSE, AngleType.RIGHT, AngleType.ACUTE};
        return angleMap[comparison + 1];
    }

    /**
     * Validates whether three sides can form a valid triangle.
     * Uses the triangle inequality theorem: sum of any two sides must be greater than the third.
     *
     * @param a the first side length
     * @param b the second side length
     * @param c the third side length
     * @return true if the sides form a valid triangle, false otherwise
     */
    public static boolean isValidTriangle(int a, int b, int c) {
        return a > 0 && b > 0 && c > 0
                && a + b > c
                && a + c > b
                && b + c > a;
    }

    /**
     * Checks if a triangle is a right triangle.
     *
     * @param a the first side length
     * @param b the second side length
     * @param c the third side length
     * @return true if the triangle is a right triangle, false otherwise
     * @throws IllegalArgumentException if any side is <= 0
     */
    public static boolean isRightTriangle(int a, int b, int c) {
        return classifyByAngle(a, b, c) == AngleType.RIGHT;
    }

    /**
     * Checks if a triangle is an obtuse triangle (one angle > 90 degrees).
     *
     * @param a the first side length
     * @param b the second side length
     * @param c the third side length
     * @return true if the triangle is obtuse, false otherwise
     * @throws IllegalArgumentException if any side is <= 0
     */
    public static boolean isObtuseTriangle(int a, int b, int c) {
        return classifyByAngle(a, b, c) == AngleType.OBTUSE;
    }

    /**
     * Checks if a triangle is an acute triangle (all angles < 90 degrees).
     *
     * @param a the first side length
     * @param b the second side length
     * @param c the third side length
     * @return true if the triangle is acute, false otherwise
     * @throws IllegalArgumentException if any side is <= 0
     */
    public static boolean isAcuteTriangle(int a, int b, int c) {
        return classifyByAngle(a, b, c) == AngleType.ACUTE;
    }

    /**
     * Computes the semiperimeter of a triangle (half the perimeter).
     * Formula: s = (a + b + c) / 2
     *
     * @param a the first side length
     * @param b the second side length
     * @param c the third side length
     * @return the semiperimeter as a double
     * @throws IllegalArgumentException if the sides do not form a valid triangle
     */
    public static double semiperimeter(int a, int b, int c) {
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }
        return (a + b + c) / 2.0;
    }

    /**
     * Computes the area of a triangle using Heron's formula.
     * Formula: area = sqrt(s * (s - a) * (s - b) * (s - c)) where s is the semiperimeter
     *
     * @param a the first side length
     * @param b the second side length
     * @param c the third side length
     * @return the area as a double
     * @throws IllegalArgumentException if the sides do not form a valid triangle
     */
    public static double area(int a, int b, int c) {
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }

        double s = semiperimeter(a, b, c);
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    /**
     * Computes the perimeter of a triangle.
     * Formula: perimeter = a + b + c
     *
     * @param a the first side length
     * @param b the second side length
     * @param c the third side length
     * @return the perimeter as an integer
     * @throws IllegalArgumentException if the sides do not form a valid triangle
     */
    public static int perimeter(int a, int b, int c) {
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }
        return a + b + c;
    }

    /**
     * Computes the height (altitude) of a triangle to the longest side.
     * Formula: height = 2 * area / base (where base is the longest side)
     *
     * @param a the first side length
     * @param b the second side length
     * @param c the third side length
     * @return the height as a double
     * @throws IllegalArgumentException if the sides do not form a valid triangle
     */
    public static double height(int a, int b, int c) {
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }

        int[] sides = sortSides(a, b, c);
        double base = sides[2];
        return 2 * area(a, b, c) / base;
    }

    private static int[] sortSides(int a, int b, int c) {
        int[] sides = {a, b, c};
        Arrays.sort(sides);
        return sides;
    }
}
