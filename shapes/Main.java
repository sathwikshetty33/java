package shapes;

public class Main {
public static void main(String[] args) {
Shape[] shapes = new Shape[3];
shapes[0] = new Circle(5.0);
shapes[1] = new Rectangle(4.0, 6.0);
shapes[2] = new Circle(2.5);
for (Shape shape : shapes) {
System.out.println("Area: " + shape.calculateArea());
}
}
}

// commandds javac *.java
// commandds java Main