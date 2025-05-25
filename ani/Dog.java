public class Dog extends Animal {
// Overriding the makeSound method
@Override
public void makeSound() {
System.out.println("The dog barks");
}
// Overloading the eat method
public void eat(String food, int quantity) {
System.out.println("The dog eats " + quantity + " units of " + food);
}
}