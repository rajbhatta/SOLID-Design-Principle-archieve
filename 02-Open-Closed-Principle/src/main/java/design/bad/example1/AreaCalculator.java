package design.bad.example1;

public class AreaCalculator {
    public double Area(Rectangle[] shapes)
    {
        double area = 0;
        for (Rectangle rectangle : shapes)
        {
            area += rectangle.getWidth()*rectangle.getHeight();
        }

        return area;
    }
}
