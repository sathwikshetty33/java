public class Cube {
private double sideLength;
// Constructor 1: No arguments, default side length
public Cube() {
this(1.0); // Call the second constructor with default value 1.0
System.out.println("Default constructor called");
}
// Constructor 2: One argument for the side length
public Cube(double sideLength) {
this(sideLength, true); // Call the third constructor with a boolean flag
System.out.println("Single parameter constructor called");
}
// Constructor 3: Two arguments, side length and a dummy boolean flag
public Cube(double sideLength, boolean dummyFlag) {
this.sideLength = sideLength;
System.out.println("Two parameter constructor called");
}
// Getter for side length
public double getSideLength() {
return sideLength;
}
// Method to calculate volume
public double calculateVolume() {
return Math.pow(sideLength, 3);
}
public static void main(String[] args) {
// Test the constructors
Cube cube1 = new Cube();
System.out.println("Cube1 side length: " + cube1.getSideLength());
System.out.println("Cube1 volume: " + cube1.calculateVolume());
Cube cube2 = new Cube(3.0);
System.out.println("Cube2 side length: " + cube2.getSideLength());
System.out.println("Cube2 volume: " + cube2.calculateVolume());
Cube cube3 = new Cube(4.0, true);
System.out.println("Cube3 side length: " + cube3.getSideLength());
System.out.println("Cube3 volume: " + cube3.calculateVolume());
}
}