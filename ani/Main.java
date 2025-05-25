public class Main {
public static void main(String[] args) {
Animal myAnimal = new Animal();
Dog myDog = new Dog();
// Demonstrate method overriding
myAnimal.makeSound(); // Should print: The animal makes a sound
myDog.makeSound(); 

// Demonstrate method overloading
myAnimal.eat("food"); // Should print: The animal eats food
myDog.eat("bone"); // Should print: The animal eats bone (inherited method)
myDog.eat("bone", 2); // Should print: The dog eats 2 units of bone (overloaded method)
}
}