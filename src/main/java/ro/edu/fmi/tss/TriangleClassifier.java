package ro.edu.fmi.tss;

import java.util.Arrays;

public class TriangleClassifier {

    private TriangleClassifier() {
        // Utility class
    }

    public static TriangleType classify(int a, int b, int c) {
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

    public static AngleType classifyByAngle(int a, int b, int c) {
        if (!isValidTriangle(a, b, c)) {
            return AngleType.INVALID;
        }

        int[] sides = sortSides(a, b, c);
        int x = sides[0];
        int y = sides[1];
        int z = sides[2];
        int sumOfSquares = x * x + y * y;
        int squareOfHypotenuse = z * z;

        if (sumOfSquares == squareOfHypotenuse) {
            return AngleType.RIGHT;
        }
        return sumOfSquares > squareOfHypotenuse ? AngleType.ACUTE : AngleType.OBTUSE;
    }

    public static boolean isValidTriangle(int a, int b, int c) {
        return a > 0 && b > 0 && c > 0
                && a + b > c
                && a + c > b
                && b + c > a;
    }

    public static boolean isRightTriangle(int a, int b, int c) {
        return classifyByAngle(a, b, c) == AngleType.RIGHT;
    }

    public static boolean isObtuseTriangle(int a, int b, int c) {
        return classifyByAngle(a, b, c) == AngleType.OBTUSE;
    }

    public static boolean isAcuteTriangle(int a, int b, int c) {
        return classifyByAngle(a, b, c) == AngleType.ACUTE;
    }

    public static double semiperimeter(int a, int b, int c) {
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }
        return (a + b + c) / 2.0;
    }

    public static double area(int a, int b, int c) {
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }

        double s = semiperimeter(a, b, c);
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static int perimeter(int a, int b, int c) {
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }
        return a + b + c;
    }

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
