package design.bad.example1;

public class AreaCalculatorV2<T> {
    public double Area(T shapes) {
        double area = 0;

        if (shapes instanceof Rectangle) {
            Rectangle rectangle = new Rectangle();
            area += rectangle.getWidth() * rectangle.getWidth();
        } else {
            Circle circle = new Circle();
            area += circle.getRadius() * circle.getRadius() * Math.PI;
        }

        return area;
    }
}
