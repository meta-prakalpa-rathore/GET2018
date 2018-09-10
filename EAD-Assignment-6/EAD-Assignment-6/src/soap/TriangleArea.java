package soap;

public class TriangleArea {

    public double getAreaOfTriangle(double sideA, double sideB, double sideC)
    {
        double halfPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }
}
