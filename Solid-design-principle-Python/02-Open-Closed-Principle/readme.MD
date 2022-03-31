## 1. OPEN-CLOSED Principle ##
- Open closed principle states that a class must be open for extending the feature but close for modification 
that is software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification

## 2. Example ##
### 2.1 Example with bad design ###
```java
Rectangle.java
package design.bad.example1;

public class Rectangle {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

```

```java
AreaCalculator.java
package design.bad.example1;

public class AreaCalculator {
    public double Area(Rectangle[] shapes)
    {
        double area = 0;
        for (Rectangle rectangle: shapes)
        {
            area += rectangle.getWidth()*rectangle.getHeight();
        }

        return area;
    }
}
```
But what will happen if want to extend it so that it could calculate the area of not only rectangles but of circles as well.
```java
package design.bad.example1;

public class AreaCalculator<T> {
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

```
Note: We modified the AreaCalculator.java class and it's method to accomodate the change. Thus, it is violating the Open/Closed principle.

```java
package design.bad.example1;

public class Circle {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

```

## 2.2 Example with good design practice ##
```java
package design.good.example1;

public abstract class Shape
{
    public abstract double Area();
}
```

```java
package design.good.example1;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double Area() {
        return width * height;
    }
}

```

```java
package design.good.example1;

public class Circle extends Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double Area() {
        return radius * radius * Math.PI;
    }
}

```

```java
package design.good.example1;

public class AreaCalculator {
    public void rectAngleArea(){
        Rectangle rectangle=new Rectangle();
        rectangle.Area();
    }

    public void circleArea(){
        Circle circle=new Circle();
        circle.Area();
    }
}

```