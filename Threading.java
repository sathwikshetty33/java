import java.util.Random;
public class Threading {
public static void main(String[] args) {
SharedNumber sharedNumber = new SharedNumber();
Thread generatorThread = new Thread(new NumberGenerator(sharedNumber));
Thread squareThread = new Thread(new SquareCalculator(sharedNumber));
Thread cubeThread = new Thread(new CubeCalculator(sharedNumber));
generatorThread.start();
squareThread.start();
cubeThread.start();
}
}
class SharedNumber {
private int number;
private boolean newNumberGenerated = false;
public synchronized void setNumber(int number) {
this.number = number;
this.newNumberGenerated = true;
notifyAll();
}
public synchronized int getNumber() throws InterruptedException {
while (!newNumberGenerated) {
wait();
}
newNumberGenerated = false;
return number;
}
}
class NumberGenerator implements Runnable {
private SharedNumber sharedNumber;
private Random random = new Random();
public NumberGenerator(SharedNumber sharedNumber) {
this.sharedNumber = sharedNumber;
}
@Override
public void run() {
while (true) {
    int number = random.nextInt(100);
System.out.println("Generated number: " + number);
sharedNumber.setNumber(number);
try {
Thread.sleep(1000);
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
}
class SquareCalculator implements Runnable {
private SharedNumber sharedNumber;
public SquareCalculator(SharedNumber sharedNumber) {
this.sharedNumber = sharedNumber;
}
@Override
public void run() {
while (true) {
try {
int number = sharedNumber.getNumber();
if (number % 2 == 0) {
System.out.println("Square of " + number + " is " + (number * number));
}
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
}
class CubeCalculator implements Runnable {
private SharedNumber sharedNumber;
public CubeCalculator(SharedNumber sharedNumber) {
this.sharedNumber = sharedNumber;
}
@Override
public void run() {
while (true) {
try {
int number = sharedNumber.getNumber();
if (number % 2 != 0) {
System.out.println("Cube of " + number + " is " + (number * number * number));
}
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
}